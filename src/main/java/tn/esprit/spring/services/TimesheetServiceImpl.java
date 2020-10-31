package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	
	private static final Logger logger = LogManager.getLogger(TimesheetServiceImpl.class);

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	public Mission ajouterMission(Mission mission) {
		return missionRepository.save(mission);
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		Optional<Mission> value = missionRepository.findById(missionId);
		
		if (value.isPresent()){
			Mission mission = value.get();
			Optional<Departement> valueDep = deptRepoistory.findById(depId);
			
			if (valueDep.isPresent()){
				
				Departement dep = valueDep.get();
				
				mission.setDepartement(dep);
				missionRepository.save(mission);
			}
		}
	}

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		logger.info("In valider Timesheet");
		Optional<Employe> valuevalidateur = employeRepository.findById(validateurId);
		Optional<Mission> valuemission = missionRepository.findById(missionId);
		
		if (valuevalidateur.isPresent() && valuemission.isPresent()){
			
			Employe validateur = valuevalidateur.get();
			Mission mission = valuemission.get();
			
			//verifier s'il est un chef de departement (interet des enum)
			if(!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
				logger.info("l'employe doit etre chef de departement pour valider une feuille de temps !");
				return;
			}
			//verifier s'il est le chef de departement de la mission en question
			boolean chefDeLaMission = false;
			for(Departement dep : validateur.getDepartements()){
				if(dep.getId() == mission.getDepartement().getId()){
					chefDeLaMission = true;
					break;
				}
			}
			if(!chefDeLaMission){
				logger.info("l'employe doit etre chef de departement de la mission en question");
				return;
			}
	//
			TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
			Timesheet timesheet =timesheetRepository.findBytimesheetPK(timesheetPK);
			timesheet.setValide(true);
			
			//Comment Lire une date de la base de données
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			logger.info("dateDebut : "+ dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));
		}
		
	}

	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
