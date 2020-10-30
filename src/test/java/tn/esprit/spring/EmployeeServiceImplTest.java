package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

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
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {
	@Autowired 
	IEmployeService es; 
	
	@Test
	public void testAddOrUpdateEmploye() throws ParseException {
	
		Employe em = new Employe("Oussama", "Gaâliche", "oussama.gaaliche@esprit.tn","oussama",true,Role.INGENIEUR);
		int employeAddedId = es.addOrUpdateEmploye(em); 
		
	}
	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(d, "CDI", 1800);
		int ContratAdded = es.ajouterContrat(c); 
		
	}
	@Test
	public void testRetrieveEmployeById() {
		String EmployeRetrieved = es.getEmployePrenomById(1); 
		
	}
	
	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = es.getAllEmployes(); 
		// if there are 5 users in DB : 
		assertEquals(5, listEmployes.size());
	}

}