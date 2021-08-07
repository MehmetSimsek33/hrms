package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.dto.SchoolDto;
import kodlama.io.hrms.entities.dto.SkillDto;
@CrossOrigin
@RestController
@RequestMapping("/api/Skill")
public class SkillController {
	@Autowired
	SkillService skillService;
	
	@GetMapping("/getAll")
	public DataResult<List<Skill>> getAll() {
	
		return this.skillService.getAll();
	}
	@GetMapping("/getAllSkillDetailDto")
	public ResponseEntity<DataResult<List<SkillDto>>> getAllCvDto(){
		
		return new ResponseEntity<>(this.skillService.getallSkillDto(), HttpStatus.OK);
	}
}
