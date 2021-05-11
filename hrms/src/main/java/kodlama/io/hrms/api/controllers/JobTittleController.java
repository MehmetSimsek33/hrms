package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.JobTitleService;
import kodlama.io.hrms.entities.concretes.job_titles;


@RestController
@RequestMapping("/api/hrms")
public class JobTittleController  {
	@Autowired
	JobTitleService jobTitleService;
	
	@GetMapping("/getall")
	public List<job_titles> getAll(){
		return this.jobTitleService.getAll();
	}
	

}
