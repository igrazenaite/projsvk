package lt.sveikata.doctor;

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

public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/admin/findUser", method = RequestMethod.GET)
	public List<DoctorForClient> giveAllDoctors() {
		return getDoctorService().receiveAllDoctors();
	}

	@RequestMapping(value = "/admin/addNew/doctor", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createDoctor(@RequestBody final AddNewDoctor newDoctor) {
		doctorService.addNewDoctor(newDoctor);
	}

	@RequestMapping(value = "/admin/findUser/manageUser", path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDoctorFromDatabase(@PathVariable final Long id) {
		doctorService.deleteDoctor(id);
	}

	@RequestMapping(value = "/admin/findUser/manageUser", path = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateExistingDoctor(@RequestBody final Doctor doctor, @PathVariable final Long id) {
		doctorService.updateDoctor(doctor, id);
	}

	public DoctorService getDoctorService() {
		return doctorService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
}
