package com.epi.springProject.GestionEtudiants.GestionEtudiants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	
	@Query("select a from Etudiant a  where a.nom like %:x%")
	List<Etudiant> rechercherParMc(@Param("x") String mc);

}
