package com.epi.springProject.GestionEtudiants.GestionEtudiants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epi.springProject.GestionEtudiants.GestionEtudiants.entity.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
	
	@Query("select a from Groupe a  where a.nom like %:x%")
	List<Groupe> rechercherParMc(@Param("x") String mc);

}
