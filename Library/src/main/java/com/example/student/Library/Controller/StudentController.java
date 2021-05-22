package com.example.student.Library.Controller;

import com.example.student.Library.Repository.StudentRepository;
import com.example.student.Library.Service.CardService;
import com.example.student.Library.Service.StudentService;
import com.example.student.Library.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CardService cardService;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody Student student)
    {
        System.out.println("Inside the create student portal ");

        studentService.createStudent(student);
        return new ResponseEntity<>("the Student is successfully added to the system",HttpStatus.CREATED);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student){

            studentService.updateStudent(student);
            return new ResponseEntity<>("Student has been updated to the system",HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestParam("id") int id){

            cardService.deactivateCard(id);
            studentService.deleteStudent(id);
            return null;
    }

    @GetMapping("/getStudent")
    public ResponseEntity getStudent(@RequestParam("id") Integer id){

        List<Student> studentList  = studentRepository.findAllById(Collections.singleton(id));
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }



}
