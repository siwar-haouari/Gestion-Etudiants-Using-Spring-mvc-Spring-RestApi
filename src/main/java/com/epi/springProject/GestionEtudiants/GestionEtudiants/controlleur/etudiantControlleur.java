package com.epi.springProject.GestionEtudiants.GestionEtudiants.controlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Etudiant;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.service.serviceAdresse;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.service.serviceEtudiant;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.service.serviceGroupe;


@Controller
@RequestMapping("/apietudiant")
public class etudiantControlleur {
	
	@Autowired
	serviceEtudiant se;
	
	@Autowired
	serviceGroupe sg;
	
	@Autowired
	serviceAdresse ad;
	
	@GetMapping("/all")
	public String getAllEtudiant(Model m) {
		
		List<Etudiant> etudiant = se.getAllEtudiants();
		m.addAttribute("listeEtudiant", etudiant);
		return "vueEtudiant";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllEtudiantByMc(@RequestParam String mc, Model m) {
		
		List<Etudiant> etudiant = se.getEtudiantBMC(mc);
		m.addAttribute("listeEtudiant", etudiant);
		return "vueEtudiant";

	}
	

	@GetMapping("/add")
	public String ajouter( Model m) {
		
		m.addAttribute("groupes",sg.getAllGroupes());
		m.addAttribute("adresses",ad.getAllAdresses());
		
		return "ajoutEtudiant";
		
	}
	
	@PostMapping("/addE")
	public String ajouteretudiant(@ModelAttribute Etudiant e, @RequestParam("file") MultipartFile mf,Model m) throws IOException {

		Integer id = e.getId();
		se.ajouterEtudiant(e, mf);
		
		if(id!=null) {
			
	     return "redirect:/apietudiant/all";
			
		}
		
		else {
			
		m.addAttribute("message", "ajout avec succes");
		m.addAttribute("groupes",sg.getAllGroupes());
		m.addAttribute("adresses",ad.getAllAdresses());

		return "ajoutEtudiant";
		
	}
}
	
	@GetMapping("/update/{id}")
	
	public String modifierEtudiant(Model m,@PathVariable int id) {
		
		m.addAttribute("groupes",sg.getAllGroupes());
		m.addAttribute("adresses",ad.getAllAdresses());
		m.addAttribute("etudiant",se.getEtudiantById(id));

		
		return "ajoutEtudiant";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerEtudiant(@PathVariable int id) throws IOException{
		
		se.supprimerEtudiant(id);
		return "redirect:/apietudiant/all";
	}
	
}