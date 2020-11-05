package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Autowired
	DepartementRepository deptRepoistory;


	public List<Departement> getAllDepartements() {
		return (List<Departement>) deptRepoistory.findAll();
	}
	
	
	
	@Override
	public void deleteAll() {
	
			deptRepoistory.deleteAll();
		
	}
	
	public Departement ajouterDepartement(Departement dpt) {
		
		try {
		logger.info("Dans la  methode ajouterDepartement()");
		logger.debug("Je vais lancer l'ajout d'un nouveau Departement .");
		deptRepoistory.save(dpt);
		logger.debug("Je viens de finir l'ajout .");
		logger.info("Out ajouterDepartement() without errors avec.");
		}
		catch (Exception e) 
		{ 
		logger.error("Erreur dans ajouterDepartement() : " + e); }
		logger.info("fin methode ajouterDepartement() .");
		return dpt ;
	
		
	}

}
