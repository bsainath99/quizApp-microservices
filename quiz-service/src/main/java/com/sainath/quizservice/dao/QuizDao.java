package com.sainath.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sainath.quizservice.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
