package com.example.demo.service;

import com.example.demo.model.Student;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
}
