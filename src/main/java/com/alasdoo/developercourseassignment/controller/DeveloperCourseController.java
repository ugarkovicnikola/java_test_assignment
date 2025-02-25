package com.alasdoo.developercourseassignment.controller;

import com.alasdoo.developercourseassignment.dto.DeveloperCourseDTO;
import com.alasdoo.developercourseassignment.service.impl.DeveloperCourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/developercourse")
@CrossOrigin
public class DeveloperCourseController {

    private final DeveloperCourseServiceImpl developerCourseServiceImpl;

    @GetMapping(value = "/getCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeveloperCourseDTO selectDeveloperCourse(@PathVariable("id") Integer id) {
        return developerCourseServiceImpl.findOne(id);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperCourseDTO> getAllDeveloperCourses() {
        return developerCourseServiceImpl.findAll();
    }

    @PostMapping(value = "/addDeveloperCourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeveloperCourseDTO saveDeveloperCourse(@RequestBody DeveloperCourseDTO developerCourseDTO) {
        return developerCourseServiceImpl.save(developerCourseDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeveloperCourseDTO updateDeveloperCourse(@PathVariable("id") Integer id, @RequestBody DeveloperCourseDTO developerCourseDTO) {
        return developerCourseServiceImpl.update(id, developerCourseDTO);
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDeveloperCourse(@PathVariable("id") Integer id) {
        developerCourseServiceImpl.remove(id);
    }

    @GetMapping(value = "/get/{courseName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperCourseDTO> findByDeveloperCourseName(@PathVariable("courseName") String courseName) {
        return developerCourseServiceImpl.findByDeveloperCourseName(courseName);
    }

    @GetMapping(value = "/getByStudentId/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperCourseDTO> getDeveloperCourseByStudentId(@PathVariable("studentId") Integer studentId) {
        return developerCourseServiceImpl.findDeveloperCourseByStudentId(studentId);
    }

    @GetMapping(value = "/getByTeacherId/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperCourseDTO> getDeveloperCourseByTeacherId(@PathVariable("teacherId") Integer teacherId) {
        return developerCourseServiceImpl.findDeveloperCourseByTeacherId(teacherId);
    }
}