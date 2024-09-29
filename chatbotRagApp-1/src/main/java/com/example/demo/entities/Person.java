package com.example.demo.entities;



import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class Person {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String email;

}
