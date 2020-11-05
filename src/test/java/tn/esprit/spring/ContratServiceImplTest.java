package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	
	@Autowired 
	IContratService cs;
	@Autowired 
	IEmployeService es;
	
	@Test
	public void testAddOrUpdateContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-10-30");
		Contrat c = new Contrat(1,d,"yosr", 500);
		
		int ContratAdded = cs.ajouterContrat(c); 
		
	}
	
	@Test
	public void testRetrieveAllContrat() {
		List<Contrat> listEmployes = cs.getAllContrats(); 
		// if there are 5 users in DB : 
	//	assertEquals(11, listEmployes.size());
	}

	@Test
	public void getContratById() throws ParseException {
		try{
	    Contrat Contratretrieved=cs.getContratById(2);
	    //assertThat(36, is(Contratretrieved.getReference()));
		}catch(Exception e){
			System.out.println("contrat with reference 2 not founded");
		}
		}
	@Test
	 public void deleteContratById() throws ParseException {
		try{
		cs.deleteById(7);
		}catch(Exception e){
			System.out.println("contrat with reference 2 not founded");
		}
		

				
					
						
					}
	

}
