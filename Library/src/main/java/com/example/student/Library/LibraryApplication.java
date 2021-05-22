package com.example.student.Library;

import com.example.student.Library.Repository.AuthorRepository;
import com.example.student.Library.Repository.BookRepository;
import com.example.student.Library.Repository.CardRepository;
import com.example.student.Library.Repository.StudentRepository;
import com.example.student.Library.model.*;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;


	@Override
	public void run(String... args) throws Exception {

		Student student = new Student("tushargarg@gmail.com","name",20,"India");

		Card card = new Card();

		card.setStudent(student);
		student.setCard(card);

		cardRepository.save(card);

		cardRepository.findAll().stream().forEach(System.out::println);
		
		
		Author author = new Author("william","william@gmail.com",45,"Italy");

		Book book = new Book("English",Genre.NON_FICTIONAL,author);

		authorRepository.save(author);

		bookRepository.save(book);

	}
}
