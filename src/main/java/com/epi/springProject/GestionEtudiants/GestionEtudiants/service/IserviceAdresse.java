package com.epi.springProject.GestionEtudiants.GestionEtudiants.service;

import java.util.List;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Adresse;


public interface IserviceAdresse {

	public void ajouterAdresse(Adresse a);
	public List<Adresse> getAllAdresses();
	public Adresse getAdresseById(int Id);
	public List<Adresse> getAdresseBMC(String motcle);
	public void supprimerAdresse(int Id);
	public void mettreAJourAdresse(Adresse a);
	
}
