package com.alasdoo.developercourseassignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "student_developer_course")
public class StudentDeveloperCourse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "student_id", nullable = false)
    private Integer studentId;
    @Column(name = "developer_course_id", nullable = false)
    private Integer developerCourseId;
    @Column(name = "classes_bought", nullable = false)
    private Integer classesBought;

}