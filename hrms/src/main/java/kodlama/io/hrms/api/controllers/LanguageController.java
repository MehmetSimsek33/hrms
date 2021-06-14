package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;

@RestController
@RequestMapping("/api/languges")
public class LanguageController {

	private LanguageService languageservice;
	
	public LanguageController(LanguageService languageservice) {
		super();
		this.languageservice = languageservice;
	}

	@GetMapping("/getAllCvLanguageDetailDto")
	public ResponseEntity<DataResult<List<CvLanguageDetailDto>>> getAllCvDto(){
		
		return new ResponseEntity<>(this.languageservice.getAllCvLanguageDetailDto(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public Result save(@RequestBody Language language){
		return this.languageservice.add(language);
		
	
	}
}
