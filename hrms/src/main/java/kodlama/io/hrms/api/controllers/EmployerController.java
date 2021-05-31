package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.dto.EmployerForRegisterDto;



@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	@Autowired
	EmployerService employerService;

	@PostMapping("/add")
	public Result add(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return this.employerService.add(employerForRegisterDto);
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
}
