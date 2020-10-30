package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	/*@Transactional
	public void deleteDepartementById(int id) {
		try {
			logger.info("Dans la  methode deleteDepartmentById()");
			logger.debug("Je vais lancer deleteDepartmentById() .");
			//entrepriseRepoistory.deleteById(entrepriseId);
	    deptRepoistory.delete(deptRepoistory.findById(id).get());	
		logger.debug("Je viens de finir le delete.");
		logger.info("Out methode deleteDepartementById() without errors avec.");
		}
		catch (Exception e) 
		{ 
			logger.error("Erreur dans methode deleteDepartementById() : " + e); }
		
		logger.info("fin methode methode deleteDepartementById .");
	}*/
	
	@Override
	public void deleteAll() {
	
			deptRepoistory.deleteAll();
		
	}

}
