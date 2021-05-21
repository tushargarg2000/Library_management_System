package com.example.student.Library.Service;

import com.example.student.Library.Repository.BookRepository;
import com.example.student.Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book){

        bookRepository.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){

        available = true;
        if(genre != null && author != null){
            return bookRepository.findBooksByGenreAuthor(genre, author, available);
        }else if(genre != null){
            return bookRepository.findBooksByGenre(genre, available);
        }else if(author != null){
            return bookRepository.findBooksByAuthor(author, available);
        }else{
            System.out.println(available);
            System.out.println("yipeeeee we have atleast reached here");
            return bookRepository.findByAvailability(available);
        }

    }
}
