package com.example.student.Library.Service;

import com.example.student.Library.Repository.AuthorRepository;
import com.example.student.Library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void createAuthor(Author author)
    {
        authorRepository.save(author);
    }

    public Optional<Author> getAuthor(Integer id){

        //List<Author> author = authorRepository.findAllById(Collections.singleton(id));

        return authorRepository.findById(id);
    }
}
