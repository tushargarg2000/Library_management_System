package com.example.student.Library.Controller;

import com.example.student.Library.Service.CardService;
import com.example.student.Library.Service.StudentService;
import com.example.student.Library.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@RestController
public class StudentController {

    //private static final int NULL = 1234;

    @Autowired
    StudentService studentService;

    @Autowired
    CardService cardService;

    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody Student student)
    {
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
    public Student getStudent()
    {

    }


}
