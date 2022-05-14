package com.epi.springProject.GestionEtudiants.GestionEtudiants.RestControleur;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Etudiant;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.service.serviceEtudiant;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("RestapiEtudiant")
public class etudiantRestControlleur {
	
	@Autowired
	serviceEtudiant se;
	
	@GetMapping("/all")
	public List<Etudiant> getAllEtudiants() {
		
		return se.getAllEtudiants();
		
	}
	
	@GetMapping("/rechercheParMc/{mc}")
	public List<Etudiant> getAllEtudiantsByMc(@PathVariable("mc") String mot) {
	
		return se.getEtudiantBMC(mot);	
	}
	

	@GetMapping(path="/getImage/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable("id") int id)throws IOException {
		return se.getImage(id);
	}
	
	@PostMapping("/add")
	public void saveEtudiant(@Valid @RequestParam("etudiant") String e ,@RequestParam("file") MultipartFile mf) throws IOException 
	{
		Etudiant ee = new ObjectMapper().readValue(e, Etudiant.class);
		se.ajouterEtudiant(ee, mf);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEtudiant(@PathVariable  int id) throws IOException 
	{
		se.supprimerEtudiant(id);
	}
	
	@PutMapping("/update")
	public void updateEtudiant(@RequestParam("etudiant") String e ,@RequestParam("file") MultipartFile mf) throws IOException 
	{
		saveEtudiant(e, mf);
		
	}

}
