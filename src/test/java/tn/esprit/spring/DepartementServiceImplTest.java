package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {
	
	@Autowired
	IDepartementService DS;
	
	@Test
	 public void testgetallDepartement() throws ParseException {
		    List<Departement> listdepartement=DS.getAllDepartements();
			assertEquals(0,listdepartement.size());
		
		}

}
