package ru.ilmira.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import ru.ilmira.persist.entity.Student;
import ru.ilmira.persist.repo.StudentRepository;


@Slf4j
@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String allStudents(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students";
    }

    @GetMapping("/new")
    public String add(Model model) {
        Student student = new Student("", 0);
        model.addAttribute("student", student);
        return "student_form";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Student student = repository.findById(id).orElse(new Student());
        model.addAttribute("student", student);
        return "student_form";
    }

    @PostMapping("/update")
    public String update(Student student) {
        repository.save(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/students";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(NotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "not_found";
    }
}