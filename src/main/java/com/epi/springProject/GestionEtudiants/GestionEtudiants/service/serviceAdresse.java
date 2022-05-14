package com.epi.springProject.GestionEtudiants.GestionEtudiants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Adresse;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.repository.AdresseRepository;

@Service
public class serviceAdresse implements IserviceAdresse{
	
	@Autowired
	AdresseRepository adr;

	@Override
	public void ajouterAdresse(Adresse a) {

		adr.save(a);
	}

	@Override
	public List<Adresse> getAllAdresses() {

		return adr.findAll();
	}

	@Override
	public Adresse getAdresseById(int Id) {

		return adr.findById(Id).get();
	}

	@Override
	public List<Adresse> getAdresseBMC(String motcle) {

		return adr.rechercherParMc(motcle);
	}

	@Override
	public void supprimerAdresse(int Id) {
		
		adr.deleteById(Id);
		
	}

	@Override
	public void mettreAJourAdresse(Adresse a) {

		adr.save(a);

	}

}
