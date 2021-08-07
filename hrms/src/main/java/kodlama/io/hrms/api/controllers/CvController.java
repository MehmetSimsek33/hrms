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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import kodlama.io.hrms.bussiness.abstracts.CvService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.ErrorDataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dto.CvDto;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;
@CrossOrigin
@RestController
@RequestMapping("/api/cvs")
public class CvController {
	
	
	private  CvService cvService;

	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Cv cv) {
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
	@PutMapping("update")
	public Result update(@RequestBody Cv cv)
	{
		return this.cvService.update(cv);
	}
	@GetMapping("/getByCvId")
	public DataResult<Cv> getByCvId(@RequestParam int id)
	{
		return this.cvService.getByCvId(id);
	}

	
	@GetMapping("/getByIdCvDto")
	public ResponseEntity<DataResult<CvDto>> getByCvDto(@RequestParam int id){
		
		return new ResponseEntity<>(this.cvService.getByCvDto(id), HttpStatus.OK);
	}

	@PostMapping("/gitHubUpdate")
	public Result updateGithub(@RequestParam String gitHubAddress, int cvId)
	{
		return this.cvService.updateGithub(gitHubAddress, cvId);
	}
	

	@PostMapping("/linkedlUpdate")
	public Result updateLinkedln(String linkedlnAddress, int cvId) 
	{
		return this.cvService.updateLinkedln(linkedlnAddress, cvId);
	}
	
	
	@PostMapping("/linkedlnDelete")
	public Result deleteLinkedln(@RequestParam int cvId) 
	{
		return this.cvService.deleteLinkedln(cvId);
	}
	
	@PostMapping("/githubDelete")
	public Result deleteGithub(@RequestParam int cvId)
	{
		return this.cvService.deleteGithub(cvId);
	}

}
