package com.epi.springProject.GestionEtudiants.GestionEtudiants.RestControleur;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Groupe;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.service.serviceGroupe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("RestapiGroupe")
public class groupetRestControlleur {
	
	@Autowired
	serviceGroupe sg;
	
	@GetMapping("/all")
	public List<Groupe> getAllGroupes() {
		
		return sg.getAllGroupes();
		
	}
	
	@GetMapping("/rechercheParMc/{mc}")
	public List<Groupe> getAllGroupesByMc(@PathVariable("mc") String mot) {
	
		return sg.getGroupeBMC(mot);
	}
	
		
	@PostMapping("/add")
	public void saveGroupe(@Valid @RequestBody Groupe g) 
	{
		 sg.ajouterGroupe(g);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteGroupe(@PathVariable  int id)
	{
		sg.supprimerGroupe(id);

	}
	
	@PutMapping("/update")
	public void updateGroupe(@RequestBody Groupe g)
	{
		saveGroupe(g);		
	}

}
