package kodlama.io.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import kodlama.io.hrms.bussiness.abstracts.CvService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.ErrorDataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dto.CvDetailDto;
import kodlama.io.hrms.entities.dto.CvDto;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;

@RestController
@RequestMapping("/api/cvs")
public class CvController {
	

	private  CvService cvService;

	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvDto cv) {
		return ResponseEntity.ok(this.cvService.add(cv));
	}
	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}
	
	@GetMapping("/getAllCvDto")
	public ResponseEntity<DataResult<List<CvDto>>> getAllCvDto(){
		
		return new ResponseEntity<>(this.cvService.getAllCvDto(), HttpStatus.OK);
	}


	
	

	

}
