package com.example.demo.resource;

import com.example.demo.model.StudentDataModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
    public StudentDataModel getStudent(@PathVariable String id) throws Exception {
        return studentService.getStudent(id);
    }

    @PostMapping("/create/{name}/{age}/{adhar}/{univ}")
    public String createEmployee(@PathVariable String name, @PathVariable String age,@PathVariable String adhar,@PathVariable String univ) {
        return studentService.createStudent(name, age,adhar,univ);
    }

    @GetMapping("/getStudents/{univ}")
    public ArrayList<StudentDataModel> getStudents(@PathVariable String univ) throws Exception {
        return  studentService.getStudents(univ);
    }
}
