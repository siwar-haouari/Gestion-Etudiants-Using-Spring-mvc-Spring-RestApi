package com.epi.springProject.GestionEtudiants.GestionEtudiants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Groupe;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.repository.GroupeRepository;

@Service
public class serviceGroupe implements IserviceGroupe{
	
	@Autowired //injection de dependance consite à eviter la dependance entre deux classes
	GroupeRepository gp;

	@Override
	public void ajouterGroupe(Groupe g) {

		gp.save(g);
	}

	@Override
	public List<Groupe> getAllGroupes() {

		return gp.findAll();
	}

	@Override
	public Groupe getGroupeById(int Id) {

		return gp.findById(Id).get();
	}

	@Override
	public List<Groupe> getGroupeBMC(String motcle) {

		return gp.rechercherParMc(motcle);
	}

	@Override
	public void supprimerGroupe(int Id) {
		
		gp.deleteById(Id);
		
	}

	@Override
	public void mettreAJourGroupe(Groupe g) {
		
		gp.save(g);
		
	}

}
