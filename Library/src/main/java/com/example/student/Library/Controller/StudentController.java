package com.example.student.Library.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    //private static final int NULL = 1234;

    @PostMapping("/createStudent")
    public ResponseEntity createStudent(){
        return null;
    }
}
