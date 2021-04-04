package com.alasdoo.developercourseassignment.controller;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.service.impl.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    private final TeacherServiceImpl teacherServiceImpl;

    @GetMapping(value = "/getTeacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO selectTeacher(@PathVariable("id") Integer id) {
        return teacherServiceImpl.findOne(id);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeacherDTO> getAllTeachers() {
        return teacherServiceImpl.findAll();
    }

    @PostMapping(value = "/addTeacher", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherServiceImpl.save(teacherDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO updateTeacher(@PathVariable("id") Integer id, @RequestBody TeacherDTO teacherDTO) {
        return teacherServiceImpl.update(id, teacherDTO);
    }

    @PutMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeacher(@PathVariable("id") Integer id) {
        teacherServiceImpl.remove(id);
    }

    @GetMapping(value = "/get/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO findByEmail(@PathVariable("email") String email) {
        return teacherServiceImpl.findByTeacherEmail(email);
    }

    @GetMapping(value = "/get/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO findByNameAndSurname(@PathVariable("name") String name, @PathVariable("surname") String surname) {
        return teacherServiceImpl.findByTeacherNameAndTeacherSurname(name, surname);
    }
}