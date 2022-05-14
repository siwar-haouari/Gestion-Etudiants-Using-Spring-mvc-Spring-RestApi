package com.epi.springProject.GestionEtudiants.GestionEtudiants.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Etudiant;
import com.epi.springProject.GestionEtudiants.GestionEtudiants.repository.EtudiantRepository;

@Service
public class serviceEtudiant implements IserviceEtudiant {

	@Autowired
	EtudiantRepository et;
	
	@Override
	public void ajouterEtudiant(Etudiant e,MultipartFile mf) throws IOException {
		
		String photo;	
		
		if(!mf.getOriginalFilename().equals("")) {
			photo = saveImage(mf);
			e.setPhoto(photo);
		}
            et.save(e);
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		
		return et.findAll();
	}

	@Override
	public Etudiant getEtudiantById(int Id) {

		return et.findById(Id).get();
	}

	@Override
	public List<Etudiant> getEtudiantBMC(String motcle) {

		return et.rechercherParMc(motcle);
	}

	@Override
	public void supprimerEtudiant(int Id)throws IOException {

		Etudiant etudiant = et.getById(Id);
		//String  chemin = System.getProperty("user.home") + "/images2022/";
		String  chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin,etudiant.getPhoto());
		Files.delete(p);
		et.delete(etudiant);
	}

	@Override
	public void mettreAJourEtudiant(Etudiant e) {

		et.save(e);

	}
	
	/**************image****/
	
	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		//pour avoir une image unique
		String nameFile = mf.getOriginalFilename(); // recuperation de la nom de l'image
		String tab[] = nameFile.split("\\."); //diviser le nom 
		String FileModif = tab[0] +"_"+System.currentTimeMillis()+"."+tab[1];//ajouter time 
		//user.dir : emplacement courant
		//String  chemin = System.getProperty("user.home") + "/images2022/";
		String  chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin,FileModif);
		Files.write(p, mf.getBytes());
		return FileModif;
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		
		String nomImage = et.findById(id).get().getPhoto();
		//Path p = Paths.get(System.getProperty("user.home")+"/images2022/",nomImage);
		Path p = Paths.get(System.getProperty("user.dir")+"/src/main/webapp/imagesdata/",nomImage);

		return Files.readAllBytes(p);//la lecture d'une image
	}


}
