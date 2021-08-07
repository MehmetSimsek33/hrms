package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.EmployeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.Employe;
@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeController {

	@Autowired
	EmployeService employeService;

	@PostMapping("/add")
	public void add(@RequestBody Employe employe) {
		this.employeService.add(employe);
	}


	@GetMapping("/getall")
	public DataResult<List<Employe>> getAll() {
		return this.employeService.getAll();
	}
	@GetMapping("/getByEmployeId")
	public DataResult<Employe> getByEmployeId(@RequestParam int id) 
	{
		return this.employeService.getByEmployeId(id);
	}
	@PutMapping("/updateEmploye")
	public Result update(@RequestBody Employe employe)
	{
		return this.employeService.update(employe);
	}

}