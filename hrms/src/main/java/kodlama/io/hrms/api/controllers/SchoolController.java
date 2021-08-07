package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.School;
import kodlama.io.hrms.entities.dto.SchoolDto;

@RestController
@CrossOrigin
@RequestMapping("/api/schools")
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("/getAllSchoolDetailDto")
	public ResponseEntity<DataResult<List<SchoolDto>>> getAllCvDto(){
		
		return new ResponseEntity<>(this.schoolService.getallSchoolDto(), HttpStatus.OK);
	}
	  @GetMapping("/getByCvId")
	    public DataResult<List<School>> getByCvId(@RequestParam int cvId){
	        return this.schoolService.getByCvId(cvId);
	    }
	  @PostMapping("/add")
	  public Result add(@RequestBody School school)
	  {
		  return this.schoolService.add(school);
		
	  }
	  @DeleteMapping("/deleteSchool")
	  public Result deleteLanguage(@RequestParam int schoolId){
	        return this.schoolService.deleteSchool(schoolId);
	    }
	  
}
