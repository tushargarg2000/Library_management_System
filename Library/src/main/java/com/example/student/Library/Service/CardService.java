package com.example.student.Library.Service;

import com.example.student.Library.Repository.CardRepository;
import com.example.student.Library.model.Card;
import com.example.student.Library.model.CardStatus;
import com.example.student.Library.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card createAndReturn(Student student){
        Card card = new Card();
        card.setStudent(student);
        student.setCard(card);

        cardRepository.save(card);

        return card;
    }

    public void deactivateCard(int student_id){

        cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }

}
