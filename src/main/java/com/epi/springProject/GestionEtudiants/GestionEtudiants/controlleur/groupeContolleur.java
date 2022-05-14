package com.epi.springProject.GestionEtudiants.GestionEtudiants.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Groupe;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.service.serviceGroupe;
@Controller
@RequestMapping("/apigroupe")
public class groupeContolleur {
	
	@Autowired
	serviceGroupe sg;
	
	@GetMapping("/all")
	public String getAllGroupe(Model m) {
		
		List<Groupe> groupe = sg.getAllGroupes();
		m.addAttribute("listeGroupe", groupe);
		return "vueGroupe";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllGroupeByMc(@RequestParam String mc, Model m) {
		
		List<Groupe> groupe = sg.getGroupeBMC(mc);
		m.addAttribute("listeGroupe", groupe);
		return "vueGroupe";

	}
	

	@GetMapping("/add")
	public String ajouter( Model m) {
		
		m.addAttribute("groupes",sg.getAllGroupes());
		
		return "ajoutGroupe";
		
	}
	
	@PostMapping("/add")
	public String ajoutergroupe(Groupe e, Model m) {

		sg.ajouterGroupe(e);
		
		return "redirect:/apigroupe/all";
		
	}
	
	@GetMapping("/update/{id}")
	
	public String modifierGroupe(Model m,@PathVariable int id) {
		
		m.addAttribute("groupe",sg.getGroupeById(id));

		
		return "ajoutGroupe";
	}
	@GetMapping("/delete/{id}")
	public String supprimerGroupe(@PathVariable int id) {
		
		sg.supprimerGroupe(id);
		return "redirect:/apigroupe/all";
	}
	
}