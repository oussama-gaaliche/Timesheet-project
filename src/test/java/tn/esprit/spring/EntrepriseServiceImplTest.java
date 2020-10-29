package tn.esprit.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService ES;
	
	
	@Test
	 public void testAjoutEntreprise() throws ParseException {
		Entreprise entreprise=new Entreprise("test1","raisonSocial");
		Entreprise entrepriseAdded = ES.ajouterEntreprise(entreprise);
		assertEquals(entreprise.getName(),entrepriseAdded.getName());
		}
		
	
		//ES.ajouterEntreprise(new Entreprise("test1","raisonSocial"));}
@Test

	 public void testUpdateEntreprise() throws ParseException {
	 Entreprise entreprise=new Entreprise(14,"TestUpdate","Update");
	 Entreprise entrepriseUpdated=ES.UpdateEntreprise(entreprise);
	 assertEquals(entreprise.getName(),entrepriseUpdated.getName());}
	 
		//ES.UpdateEntreprise(new Entreprise(12,"TestUpdate","Update"));}
	
	 	@Test
	 public void testgetallEntreprise() throws ParseException {
			List<Entreprise> listentreprises=ES.getallEntreprises();
			assertEquals(5,listentreprises.size());
		
		}

	 	
	
	@Test

	 public void getEntrepriseById() throws ParseException {
	    Entreprise entrepriseretrieved=ES.getEntrepriseById(2);

	    assertThat(21, is(entrepriseretrieved.getId()));
		}
		//Entreprise entrepriseretrieved= ES.getEntrepriseById(14);
		
	@Test
	 public void testdeleteAll() throws ParseException {
		ES.deleteAll();
		List<Entreprise> listentreprises=ES.getallEntreprises();
			assertEquals(0,listentreprises.size());}
	
	 @Test

	  public void deleteEntrepriseById() throws ParseException {
		ES.deleteEntrepriseById(4);

			
				
					
				}


//	@Test
//	 public void testAffecterDepAentreprise() throws ParseException {
//		ES.affecterDepartementAEntreprise(6,22);
//		}
//  
//
//	@Test
//	 public void testgetAllDepartementsNamesByEntreprise() throws ParseException {
//		List<String> listeName=ES.getAllDepartementsNamesByEntreprise(21);
//		assertEquals(5,listeName.size());}

	
	
		
	
		
		
	

}
