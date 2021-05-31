package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.EmployeService;
import kodlama.io.hrms.entities.concretes.Employe;

@RestController
@RequestMapping("/api/employees")
public class EmployeController {

	@Autowired
	EmployeService employeService;

	@PostMapping("/add")
	public void add(@RequestBody Employe employe) {
		this.employeService.add(employe);
	}

}