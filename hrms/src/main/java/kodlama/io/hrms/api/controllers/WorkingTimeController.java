package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.WorkingTimeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.concretes.WorkingTime;
@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimeController {
	@Autowired
	private WorkingTimeService workingTimeService;
	
	@GetMapping("/getall")
	public DataResult<List<WorkingTime>> getAll() {
		return this.workingTimeService.getAll();
	}
}