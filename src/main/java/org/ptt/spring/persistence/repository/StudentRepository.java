package org.ptt.spring.persistence.repository;

import org.ptt.spring.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    List<Student> findAllBySurname(String surname);

    List<Student> findAllBySurnameAndName(String surname, String name);


}
