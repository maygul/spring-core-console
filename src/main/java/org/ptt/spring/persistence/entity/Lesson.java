package org.ptt.spring.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "course_length", nullable = false)
    private Integer courseLength;

    @Column(name = "course_level", nullable = false)
    private Integer courseLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
/*
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_1', 10, 1, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_2', 20, 2, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_3', 30, 3, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_4', 40, 4, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_5', 50, 5, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_6', 60, 6, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_7', 70, 7, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_8', 80, 8, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_9', 90, 9, 1);
 insert into lesson (name, course_length, course_level, student_id) values ('Lesson_10', 100, 10, 1);

 */