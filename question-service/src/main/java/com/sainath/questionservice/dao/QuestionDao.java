package com.sainath.questionservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sainath.questionservice.model.Question;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
List<Question> findByCategory(String category);

@Query(value="select q.id from question q where q.category=:category order by random() LIMIT :numQ",nativeQuery = true)
List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
