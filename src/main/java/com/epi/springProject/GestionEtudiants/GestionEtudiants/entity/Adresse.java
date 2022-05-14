package com.epi.springProject.GestionEtudiants.GestionEtudiants.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adresse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int codepostal;
	
	@NotEmpty(message = "ville may not be empty")
	private String ville;
	
	@NotEmpty(message = "rue may not be empty")
	private String rue;
	
	@OneToMany(mappedBy = "adresse", cascade = CascadeType.ALL)
	@JsonProperty(access=Access.WRITE_ONLY)//prend en charge la liste en mode d'ecriture
	List<Etudiant>liste;
}
