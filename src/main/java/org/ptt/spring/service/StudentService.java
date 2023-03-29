package org.ptt.spring.service;

import org.ptt.spring.persistence.entity.Lesson;
import org.ptt.spring.persistence.entity.Student;
import org.ptt.spring.persistence.repository.StudentRepository;
import org.ptt.spring.persistence.specification.StudentSpecification;
import org.ptt.spring.persistence.specification.criteria.StudentSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllBySurname(String surname) {
        return studentRepository.findAllBySurname(surname);
    }

    public void studentWithLessonsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        for (int i = 0; i < student.getLessons().size(); i++) {
            Lesson lesson = student.getLessons().get(i);

            System.out.println("Lesson: " + lesson.getName());
        }
    }

    public List<Student> search(Integer pageNumber, Integer pageCount, StudentSearchCriteria criteria) {
        Specification<Student> specification = StudentSpecification.findByCriteria(criteria);
        Pageable pageble = PageRequest.of(pageNumber, pageCount);

        Page<Student> all = studentRepository.findAll(specification, pageble);

        return all.getContent();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student update(Student student) {
        Student existing = getById(student.getId());

        existing.setName(student.getName());
        existing.setSurname(student.getSurname());

        return studentRepository.save(existing);
    }

    public void delete(Long id) {
        Student existing = getById(id);

        studentRepository.delete(existing);
    }

    @Transactional
    public void saveAndDelete(Student student) throws SQLException {
        try {
            save(student);
            if (student.getId() != null) {
                throw new SQLException("Roll back will happen with id :" + student.getId());
            }
            student.setName("UPDATED");
            update(student);
            delete(student.getId());
        } catch (Exception ex) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Transactional
    public void saveAndDeleteRuntimeExceptionRollback(Student student) {
        save(student);
        if (student.getId() != null) {
            throw new IllegalArgumentException("Roll back will happen with id :" + student.getId());
        }
        student.setName("UPDATED");
        update(student);
        delete(student.getId());
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public void saveAndDeleteRuntimeExceptionNoRollback(Student student) {
        save(student);
        if (student.getId() != null) {
            throw new IllegalArgumentException("Roll back will happen with id :" + student.getId());
        }
        student.setName("UPDATED");
        update(student);
        delete(student.getId());
    }

    @Transactional
    public void saveAndDeleteCheckedExceptionNoRollBack(Student student) {
        save(student);
        if (student.getId() != null) {
            throw new IllegalArgumentException("Roll back will happen with id :" + student.getId());
        }
        student.setName("UPDATED");
        update(student);
        delete(student.getId());
    }

    @Transactional(rollbackFor = SQLException.class)
    public void saveAndDeleteCheckedExceptionRollBack(Student student) throws SQLException {
        save(student);
        if (student.getId() != null) {
            throw new SQLException("Roll back will happen with id :" + student.getId());
        }
        student.setName("UPDATED");
        update(student);
        delete(student.getId());
    }
}
