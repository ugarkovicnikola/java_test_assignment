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
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "teacher_name", nullable = false, length = 250)
    private String teacherName;
    @Column(name = "teacher_surname", nullable = false, length = 250)
    private String teacherSurname;
    @Column(name = "teacher_email", nullable = false, length = 250, unique = true)
    private String teacherEmail;

}