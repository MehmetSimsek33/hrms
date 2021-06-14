package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.JobExperinceService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;
import kodlama.io.hrms.entities.dto.jobExperinceDto;

@RestController
@RequestMapping("/api/job_experinces")
public class JobExperinceController {
	
	@Autowired
	JobExperinceService jobExperinceService;
	
	@GetMapping("/getAllCvLanguageDetailDto")
	public ResponseEntity<DataResult<List<jobExperinceDto>>> getAllCvDto(){
		
		return new ResponseEntity<>(this.jobExperinceService.getalljobExperinceDto(), HttpStatus.OK);
	}
}
