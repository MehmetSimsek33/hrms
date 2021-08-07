package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.FavoriteJobPostingService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employe;
import kodlama.io.hrms.entities.concretes.FavoriteJobPosting;

@CrossOrigin
@RestController
@RequestMapping("/api/favoriteJobPosting")
public class FavoriteJobPostingController {

	@Autowired
	FavoriteJobPostingService favoriteJobPostingService;
	
	@GetMapping("/getall")
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return this.favoriteJobPostingService.getAll();
	}
	@PostMapping("/addFavoriteJobPosting")
	Result add(int candidateId, int jobPostingId) {
		return this.favoriteJobPostingService.add(candidateId,jobPostingId);
	}
}
