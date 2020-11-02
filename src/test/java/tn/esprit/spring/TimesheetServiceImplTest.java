package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	
	@Autowired
	ITimesheetService ts;
	
	@Test
	public void testajouterMission(){
		Mission mission = new Mission("Encadrer", "Encadrer les PFEs");
		assertEquals(mission.getName(), ts.ajouterMission(mission).getName());
	}
	
	@Test
	public void testajouterTimesheet(){
		
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(new Date());
		timesheetPK.setDateFin(new Date());
		timesheetPK.setIdEmploye(1);
		timesheetPK.setIdMission(1);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		
		assertEquals(timesheet.getMission(), ts.ajouterTimesheet(1, 1, new Date(), new Date()).getMission());
	}	
	
	@Test 
	public void testfindAllMissionByEmployeJPQL(){
		
		List<Mission> missions = ts.findAllMissionByEmployeJPQL(1);
		//assertEquals(0, missions.size());
	}
		
	
		
		
	

}
