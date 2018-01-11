package lt.sveikata.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/admin/findUser", method = RequestMethod.GET)
	public List<PatientForClient> giveAllPatiens() {
		return getPatientService().receiveAllPatients();
	}

	@RequestMapping(value = "/admin/addNew/patient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createPatient(@RequestBody final AddNewPatient newPatient) {
		patientService.addNewPatient(newPatient);
	}

	@RequestMapping(value = "/admin/findUser/manageUser", path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePatientFromDatabase(@PathVariable final Long id) {
		patientService.deletePatient(id);
	}

	@RequestMapping(value = "/admin/findUser/manageUser", path = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateExistingPatient(@RequestBody final Patient patient, @PathVariable final Long id) {
		patientService.updatePatient(patient, id);
	}

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
}
