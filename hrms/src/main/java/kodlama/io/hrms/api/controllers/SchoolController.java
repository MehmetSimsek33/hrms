package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;
import kodlama.io.hrms.entities.dto.SchoolDto;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
	@GetMapping("/getAllCvLanguageDetailDto")
	public ResponseEntity<DataResult<List<SchoolDto>>> getAllCvDto(){
		
		return new ResponseEntity<>(this.schoolService.getallSchoolDto(), HttpStatus.OK);
	}
}
