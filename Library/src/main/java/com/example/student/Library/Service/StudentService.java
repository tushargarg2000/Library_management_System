package com.example.student.Library.Service;

import com.example.student.Library.Repository.CardRepository;
import com.example.student.Library.Repository.StudentRepository;
import com.example.student.Library.model.Card;
import com.example.student.Library.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    CardService cardService;

    @Autowired
    StudentRepository studentRepository;


    public void createStudent(Student student){
        Card newCard = cardService.createAndReturn(student);
        logger.info("The card for the student {} is created with the details - {}", student, newCard);

    }

    public void updateStudent(Student student){
        studentRepository.updateStudentDetails(student);
    }

    public void deleteStudent(int id){

        cardService.deactivateCard(id);
        studentRepository.deleteCustom(id);
    }

}
