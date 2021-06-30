package com.spring.project.hibernateAndJpa.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kategori")
@EnableAutoConfiguration
public class Kategori {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kategori_id")
	private int kategoriId;
	
	@Column(name ="kategori_adi" , nullable = false  )
	private String kategoriName;
	
	@Column(name ="kategori_adia" , nullable = false)
	private String kategoriNamae;
	
}
