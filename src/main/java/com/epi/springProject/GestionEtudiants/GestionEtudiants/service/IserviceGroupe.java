package com.epi.springProject.GestionEtudiants.GestionEtudiants.service;

import java.util.List;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Groupe;

public interface IserviceGroupe {

	
	public void ajouterGroupe(Groupe g);
	public List<Groupe> getAllGroupes();
	public Groupe getGroupeById(int Id);
	public List<Groupe> getGroupeBMC(String motcle);
	public void supprimerGroupe(int Id);
	public void mettreAJourGroupe(Groupe g);
}
