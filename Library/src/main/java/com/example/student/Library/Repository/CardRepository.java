package com.example.student.Library.Repository;

import com.example.student.Library.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {


}
