package org.ptt.spring.persistence.specification.criteria;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentSearchCriteria {
    private String name;
    private String surname;
}
