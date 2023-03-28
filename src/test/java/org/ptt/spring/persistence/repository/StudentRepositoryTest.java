package org.ptt.spring.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ptt.spring.config.SpringBeanConfig;
import org.ptt.spring.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringBeanConfig.class})
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void givenStudent_thenSaveSuccessfully() {
        Student student = Student.builder()
                .name("Student_1")
                .surname("Surname_1")
                .build();
        studentRepository.save(student);

        assertNotNull(student.getId());
    }

    @Test
    void givenStudentId_thenFindSuccessfully() {
        Long studentId = 1l;
        Student student = studentRepository.findById(studentId).orElse(null);
        assertNotNull(student);
    }

    @Test
    void givenStudentId_thenFindAndUpdateSuccessfully() {
        Long studentId = 2L;

        Optional<Student> optionalStudent = Optional.empty();

        Student student = studentRepository.findById(studentId).orElse(null);

        assertNotNull(student);

        student.setName("updated Student_2___");
        student.setSurname("updated Surname_2______");

        studentRepository.save(student);

    }

    @Test
    void givenStudent_thenSaveAndDeleteSuccessfully() {
        Student student = Student.builder()
                .name("Student_3")
                .surname("Surname_3")
                .build();
        studentRepository.save(student);

        assertNotNull(student.getId());

        studentRepository.delete(student);
    }

    @Test
    void givenStudentSurname_ThenFindAllTheseRecords() {
        String surname = "Surname_1";

        List<Student> allBySurname = studentRepository.findAllBySurname(surname);

        assertNotNull(allBySurname);
    }

    @Test
    void givenStudentNameAndSurname_thenFindMethodQueryStudentResults() {
        String surname = "updated Surname_2______";
        String name = "updated Student_2___";

        List<Student> studentList = studentRepository.findAllBySurnameAndName(surname, name);


        assertNotNull(studentList);
    }
}
