package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
  public class MainController {
  @Autowired
  private StudentService studentService;
  @GetMapping("/list")
  public String listPage(Model model){
    List<Student> students = studentService.findAll();
    model.addAttribute("students",students);
    return "list";
  }
  @GetMapping("/create")
public String createPage(Model model) {
    model.addAttribute("student",new Student());
    return "create";
  }
  @PostMapping("/create")
  public String saveStudent(@ModelAttribute Student student){
    studentService.save(student);
    return "redirect:/list";
  }
}

