package org.ptt.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ptt.spring.config.SpringBeanConfig;
import org.ptt.spring.persistence.entity.Student;
import org.ptt.spring.persistence.specification.criteria.StudentSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringBeanConfig.class})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void givenStudentId_thenRetrieveStudents() {
        Long studentId = 1L;

        studentService.studentWithLessonsById(studentId);
    }

    @Test
    void givenSearchParams_thenRetrieveRecordsSuccessfully() {
        Integer pageNumber = 0;
        Integer pageCount = 2;

        StudentSearchCriteria criteria = new StudentSearchCriteria(null, "Surname_1");

        List<Student> searchResult = studentService.search(pageNumber, pageCount, criteria);

        assertNotNull(searchResult);
    }

    @Test
    void givenStudent_thenSaveAndDeleteSuccessfully() throws SQLException {
        Student student = Student.builder()
                .name("updated Student_1____")
                .surname("updated Surname_1+_____")
                .build();

        studentService.saveAndDelete(student);

    }
}
