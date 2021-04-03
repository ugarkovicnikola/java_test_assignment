package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public TeacherDTO findOne(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the following id = " + id + " is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream()
            .map(teacher -> teacherMapper.transformToDTO(teacher))
            .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
        return teacherMapper.transformToDTO(teacherRepository.save(teacher));
    }

    @Override
    public void remove(Integer id) throws IllegalArgumentException {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the following id = " + id + " is not found.");
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
        Optional<Teacher> oldTeacher = teacherRepository.findById(id);
        if (!oldTeacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the following id = " + id + " is not found.");
        }
        oldTeacher.get().setTeacherEmail(teacherDTO.getTeacherEmail());
        oldTeacher.get().setTeacherName(teacherDTO.getTeacherName());
        oldTeacher.get().setTeacherSurname(teacherDTO.getTeacherSurname());
        teacherRepository.save(oldTeacher.get());
        return teacherMapper.transformToDTO(oldTeacher.get());
    }

    @Override
    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherNameAndTeacherSurname(name, surname);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the provided name and surname combination is not found." );
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

    @Override
    public TeacherDTO findByTeacherEmail(String email) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherEmail(email);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the following email = " + email + " is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }
}
