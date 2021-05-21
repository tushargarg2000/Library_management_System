package com.example.student.Library.Controller;

import com.example.student.Library.Service.AuthorService;
import com.example.student.Library.model.Author;
import com.example.student.Library.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/createAuthor")
    public ResponseEntity createAuthor(@RequestBody Author author)
    {
        System.out.println("Inside the create Create ");

        authorService.createAuthor(author);
        return new ResponseEntity<>("the Author is successfully added to the system", HttpStatus.CREATED);
    }



}
