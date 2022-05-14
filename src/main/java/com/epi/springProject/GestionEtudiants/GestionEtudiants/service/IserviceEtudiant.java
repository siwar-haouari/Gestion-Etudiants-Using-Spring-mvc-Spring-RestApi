package com.epi.springProject.GestionEtudiants.GestionEtudiants.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Etudiant;

public interface IserviceEtudiant {
	
	public void ajouterEtudiant(Etudiant e,MultipartFile mf) throws IOException ;
	public List<Etudiant> getAllEtudiants();
	public Etudiant getEtudiantById(int Id);
	public List<Etudiant> getEtudiantBMC(String motcle);
	public void supprimerEtudiant(int Id)throws IOException;
	public void mettreAJourEtudiant(Etudiant e);
	String saveImage(MultipartFile mf)throws IOException ;
	byte[]  getImage(int id)throws IOException;

}
