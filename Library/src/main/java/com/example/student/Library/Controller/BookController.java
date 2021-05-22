package com.example.student.Library.Controller;

import com.example.student.Library.Service.BookService;
import com.example.student.Library.model.Author;
import com.example.student.Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


//    @PostMapping("/createAuthor")
//    public ResponseEntity createAuthor(@RequestBody Author author)
//    {
//        System.out.println("Inside the create Create ");
//
//        authorService.createAuthor(author);
//        return new ResponseEntity<>("the Author is successfully added to the system", HttpStatus.CREATED);
//    }


    @PostMapping("/createBook")
    public ResponseEntity createBook(@RequestBody Book book){

        bookService.createBook(book);
        return new ResponseEntity<>("the book is added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){


        System.out.println("consoling parameters " + genre + " " + available + " " + author);
        List<Book> bookList = bookService.getBooks(genre, available, author);

        System.out.println("this is where the list seems to be reached");

        bookList.forEach(System.out::println);
        System.out.println("good good reached here well");
        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }

}

