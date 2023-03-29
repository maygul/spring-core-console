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
}
