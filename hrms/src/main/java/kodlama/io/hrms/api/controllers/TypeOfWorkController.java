package kodlama.io.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.TypeOfWorkService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.concretes.TypeOfWork;

@RestController
@RequestMapping("/api/typeOfWorks")
@CrossOrigin
public class TypeOfWorkController {
	@Autowired
	private TypeOfWorkService typeOfWorkService;

	@GetMapping("/getall")
	public DataResult<List<TypeOfWork>> getAll() {
		return this.typeOfWorkService.getAll();
	}
}