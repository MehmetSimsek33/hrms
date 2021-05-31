package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dto.CandidateForRegisterDto;


@RestController
@RequestMapping("/api/candidates")
public class CandidatesController 
{	
		@Autowired
		private CandidateService candidateService;
		
		
		@GetMapping("/getall")
		public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody CandidateForRegisterDto candidateForRegisterDto)
		{
		 return this.candidateService.add(candidateForRegisterDto);
		}
			
		}
