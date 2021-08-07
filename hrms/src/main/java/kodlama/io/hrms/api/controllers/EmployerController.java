package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.TempEmployer;
import kodlama.io.hrms.entities.dto.EmployerForRegisterDto;


@CrossOrigin
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
	@GetMapping("/getallTempEmploye")
	public DataResult<List<TempEmployer>> getAllTempEmploye() {
		return this.employerService.getAllTempEmployer();
	}
	@PutMapping("/update")
	public Result Update(@RequestBody Employer employer)
	{
		return this.employerService.Update(employer);
	}
	@GetMapping("/getById")
	public DataResult<Employer> getById(@RequestParam int id) 
	{
		return this.employerService.getById(id);
	}

	@PutMapping("/updateTemp")
	public Result updateTemp(@RequestBody TempEmployer tempEmployer)
	{
		return this.employerService.updateTemp(tempEmployer);
	}
	@PutMapping("/verifyUpdate")
	public Result verifyUpdate(@RequestParam int employerId)
	{
		return this.employerService.verifyUpdate(employerId);
	}
	  @DeleteMapping("/deleteTempEmployer")
	  public Result deleteLanguage(@RequestParam int tempEmployeId){
	        return this.employerService.deleteTempEmploye(tempEmployeId);
	    }
}
