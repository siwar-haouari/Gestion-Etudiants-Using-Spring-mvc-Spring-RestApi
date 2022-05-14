package com.epi.springProject.GestionEtudiants.GestionEtudiants.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Groupe {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=true)
	private String nom;
	
	@OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
	@JsonProperty(access=Access.WRITE_ONLY)//prend en charge la liste en mode d'ecriture
	List<Etudiant>liste;
	
	

}
