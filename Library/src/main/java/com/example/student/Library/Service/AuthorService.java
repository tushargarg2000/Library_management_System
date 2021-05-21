package com.example.student.Library.Service;

import com.example.student.Library.Repository.AuthorRepository;
import com.example.student.Library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void createAuthor(Author author)
    {
        authorRepository.save(author);
    }
}
