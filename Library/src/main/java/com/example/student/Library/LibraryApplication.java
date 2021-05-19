package com.example.student.Library;

import com.example.student.Library.Repository.CardRepository;
import com.example.student.Library.Repository.StudentRepository;
import com.example.student.Library.model.Card;
import com.example.student.Library.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	@Override
	public void run(String... args) throws Exception {

		Student student = new Student("tushargarg@gmail.com","name",20,"India");

		Card card = new Card();

		card.setStudent(student);
		student.setCard(card);

		cardRepository.save(card);
	}
}
