package com.epi.springProject.GestionEtudiants.GestionEtudiants.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //permet de remplacer tous les getters et setters des attributs.
@AllArgsConstructor // permet de remplacer le constructeur par défaut
@NoArgsConstructor // permet de remplacer le constructeur avec paramètres
@Entity
public class Etudiant {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private String prenom;
	private String email;
	private Integer numtel;
	private String photo;
	
	@ManyToOne
	private Groupe groupe;

	@ManyToOne
	private Adresse adresse;

}
