package com.sainath.quizservice.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
@Data
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@ElementCollection
	private List<Integer> questionIds;
	
}
