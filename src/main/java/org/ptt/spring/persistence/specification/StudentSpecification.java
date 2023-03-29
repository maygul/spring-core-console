package org.ptt.spring.persistence.specification;

import org.ptt.spring.persistence.entity.Student;
import org.ptt.spring.persistence.specification.criteria.StudentSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification {
    public static Specification<Student> findByCriteria(StudentSearchCriteria criteria) {
        return (root, query, cb) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (criteria.getName() != null || !criteria.getName().isBlank()) {
                Predicate namePredicate = cb.equal(root.get("name"), criteria.getName());
                predicateList.add(namePredicate);
            }

            if (criteria.getSurname() != null || !criteria.getSurname().isBlank()) {
                Predicate surnamePredicate = cb.equal(root.get("surname"), criteria.getSurname());
                predicateList.add(surnamePredicate);
            }

            return cb.and(predicateList.toArray(new Predicate[]{}));
        };
    }
}
