package com.luv2code.springdemo.config.controller;

import com.luv2code.springdemo.config.dto.Student;
import com.luv2code.springdemo.config.dto.StudentErrorResponse;
import com.luv2code.springdemo.config.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/studentlist}")
    public List<Student> getStudent() {

        ArrayList<Student> listS = initializeStudentList();
        return listS;

    }


    @GetMapping("/studentlist/{studentID}")
    public Student getStudentList(@PathVariable int studentID) {

        ArrayList<Student> listS = initializeStudentList();

        if (studentID >= listS.size() || studentID < 0) {
            throw new StudentNotFoundException("Student ID not found : " + studentID);
        }

        return listS.get(studentID);

    }

    private ArrayList<Student> initializeStudentList() {

        ArrayList<Student> listS = new ArrayList<>();

        listS.add(new Student("Tom", "Boy", 1));
        listS.add(new Student("Mary", "Girl", 2));
        listS.add(new Student("jason", "good", 3));
        listS.add(new Student("pumpkin", "face", 4));

        return listS;
    }



}