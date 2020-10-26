package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public Entreprise ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public void deleteEntrepriseById(int id);
	public void deleteDepartementById(int depId);
	public Entreprise getEntrepriseById(int entrepriseId);
	public Entreprise UpdateEntreprise(Entreprise entreprise);
	public void deleteAll();
	List<Entreprise> getallEntreprises();
}
