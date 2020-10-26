package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.Logger;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;


@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	public static void main(String[] args) { 
	EntrepriseServiceImpl al = new EntrepriseServiceImpl(); 
	//al.ajouterEntreprise();}
	//al.deleteEntrepriseById();
	al.affichage();}
	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public Entreprise ajouterEntreprise(Entreprise entreprise) {
	
		try {
		logger.info("Dans la  methode ajouterEntreprise()");
		logger.debug("Je vais lancer l'ajout d'une nouvelle entreprise .");
		entrepriseRepoistory.save(entreprise);
		logger.debug("Je viens de finir l'ajout .");
		logger.info("Out ajouterEntreprise() without errors avec.");
		}
		catch (Exception e) 
		{ 
		logger.error("Erreur dans ajouterEntreprise() : " + e); }
		logger.info("fin methode ajouterEntreprise() .");
		return entreprise ;
	
		
	}

	public int ajouterDepartement(Departement dep) {
		try {
			logger.info("Dans la  methode  ajouterDepartement()");
			logger.debug("Je vais lancer l'ajout  ajouterDepartement().");
		deptRepoistory.save(dep);
		
		logger.debug("Je viens de finir l'ajout .");
		logger.info("Out  ajouterDepartement() without errors avec.");
		  return dep.getId();
		}
		catch (Exception e) 
		{ 
		logger.error("Erreur dans  ajouterDepartement() : " + e); }
		logger.info("fin methode ajouterDepartement() .");
		return 1;
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		try{
		logger.info("Dans la  methode  AffecterDepartement()");
		logger.debug("Je vais lancer l'ajout  AffecterDepartement().");
		
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				logger.debug("avant save");
				deptRepoistory.save(depManagedEntity);
				logger.debug("aprés save");
				
				logger.debug("Je viens de finir l'ajout .");
				logger.info("Out AffecterDepartement() without errors avec.");
				}
		catch (Exception e) 
		{ 
		logger.error("Erreur dans  AffecterDepartement() : " + e); }
		logger.info("fin methode AffecterDepartement() .");
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> depNames = new ArrayList<>();
		try{
			logger.info("Dans la  methode   getAllDepartementsNamesByEntreprise()");
			logger.debug("Je vais lancer  getAllDepartementsNamesByEntreprise().");
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		//List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
			logger.debug("Avant de sortir de boucle for .");
		}
		
		logger.debug("Je viens de finir  getAllDepartementsNamesByEntreprise .");
		logger.info("Out  getAllDepartementsNamesByEntreprise() without errors avec.");
		}
		catch (Exception e) 
		{ 
		logger.error("Erreur dans  AffecterDepartement() : " + e); }
		logger.info("fin methode AffecterDepartement() ."+depNames);
		return depNames;
		
	}

	@Transactional
	public void deleteEntrepriseById(int id) {
		try {
			logger.info("Dans la  methode deleteEntrepriseById()");
			logger.debug("Je vais lancer deleteEntrepriseById() .");
			//entrepriseRepoistory.deleteById(entrepriseId);
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(id).get());	
		logger.debug("Je viens de finir le delete.");
		logger.info("Out methode deleteEntrepriseById() without errors avec.");
		}
		catch (Exception e) 
		{ 
			logger.error("Erreur dans methode deleteEntrepriseById() : " + e); }
		
		logger.info("fin methode methode deleteEntrepriseById() .");
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		try {
			logger.info("Dans la  methode deleteEntrepriseById()");
			logger.debug("Je vais lancer deleteEntrepriseById() .");
		
		//return entrepriseRepoistory.findById(entrepriseId).get();
		logger.info("Dans la  methode deleteEntrepriseById()"+entrepriseRepoistory.findById(entrepriseId).get().toString());
		logger.debug("Je viens de finir le delete.");
		logger.info("Out methode deleteEntrepriseById() without errors avec.");
		}
		catch (Exception e) 
		{ 
			logger.error("Erreur dans methode deleteEntrepriseById() : " + e); }
		
		logger.info("fin methode methode deleteEntrepriseById() .");
		return entrepriseRepoistory.findById(entrepriseId).get();
		
	}
	public void  affichage(){
		try {
			logger.info("Dans la  affichage()");
			logger.debug("Je vais lancer affichage() .");
			System.out.println("hello");
			logger.debug("Je viens de finir le delete.");
			logger.info("Out methode affichage() without errors avec.");}
		catch (Exception e) 
		{ 
			logger.error("Erreur dans methode affichage() : " + e); }
		logger.info("fin methode methode affichage() .");
		
		
		
		
	}

	@Override
	public Entreprise UpdateEntreprise(Entreprise entreprise) {
		try {
			logger.info("Dans la  UpdateEntreprise()");
			logger.debug("Je vais lancer UpdateEntreprise() .");
		entrepriseRepoistory.save(entreprise);
		logger.debug("Je viens de finir l'UpdateEntreprise().");
		logger.info("Out methode UpdateEntreprise() without errors .");
		return entreprise;
		
		}
		catch (Exception e) 
		{ 
			logger.error("Erreur dans methode UpdateEntreprise() : " + e); }
		logger.info("fin methode methode UpdateEntreprise() .");
		return entreprise;
	
		
	}

	@Override
	public void deleteAll() {
		try {
			logger.info("Dans la  methode deleteAll()");
			logger.debug("Je vais lancer deleteAll() .");
			entrepriseRepoistory.deleteAll();
			logger.debug("Je viens de finir deleteAll().");
			logger.info("Out methode deleteAll() without errors .");
			
			}
		catch (Exception e) 
		{ 
			logger.error("Erreur dans methode deleteAll() : " + e); }
		logger.info("fin methode methode deleteAll() .");
		
	}

	@Override
	public List<Entreprise> getallEntreprises() {
		List<Entreprise> entreprises=(List<Entreprise>)entrepriseRepoistory.findAll();
		return entreprises;
	}

}
