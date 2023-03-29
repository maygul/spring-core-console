package org.ptt.spring.persistence.repository;

import org.ptt.spring.persistence.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    List<Student> findAllBySurname(String surname);

    List<Student> findAllBySurnameAndName(String surname, String name);

    @Query(value = "SELECT * FROM student WHERE surname = ?1", nativeQuery = true)
    List<Student> findAllBySurnameNative(String surname);

    @Query(value = "SELECT * FROM student WHERE surname = :surname", nativeQuery = true)
    List<Student> findAllBySurnameNativeSecondQuery(@Param("surname") String surname);

    @EntityGraph(attributePaths = {"lessons"})
    Optional<Student> findById(Long id);

    @Query("SELECT s,l FROM Student s JOIN FETCH Lesson l ON s.id = l.student.id WHERE s.id = :id")
    Student findStudentWithCustomQuery(@Param("id") Long id);

}
