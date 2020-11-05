package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}
	
	public int ajouterContrat(Contrat contrat) {
		l.info("In  ajouterContrat : "+contrat); 
		contratRepository.save(contrat);
		l.info("Out  ajouterContrat : "); 
		return contrat.getReference();
	}
	
	public Contrat getContratById(int id){
		l.info("In  Contrat have as reference : "+ id);
		return   contratRepository.findByReference(id);
	}
	
	public void deleteById(int id){
		Contrat c=new Contrat();
		c=getContratById(id);
		contratRepository.delete(c);
	}

}
