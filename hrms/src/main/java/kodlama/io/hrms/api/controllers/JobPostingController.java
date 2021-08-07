	package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.bussiness.abstracts.JobPostingService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.entities.concretes.JobPosting;
import kodlama.io.hrms.entities.dto.JobAdFilter;
@CrossOrigin
@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {
	@Autowired
	JobPostingService jobPostingService;

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@GetMapping("/getalltrue")
	public DataResult<List<JobPosting>> getByStatus(boolean status) {
		return this.jobPostingService.getByStatus(status);
	}

	@GetMapping("/getallstatusanddate")
	public DataResult<List<JobPosting>> getByStatus2(boolean status) {
		return this.jobPostingService.getAllStatusAndDate(status);
	}

	@GetMapping("/getbystatusandemployer")
	public DataResult<List<JobPosting>> getByStatusAndEmployerId(boolean status, int employerId) {
		return this.jobPostingService.getByStatusAndEmployerId(status, employerId);
	}

	@PostMapping("/update")
	public Result updateStatus(@RequestBody JobPosting jobPosting) {
		this.jobPostingService.Update(jobPosting);
		return new SuccesResult("başarılı");
	}
	@PostMapping("/statusUpdate")
	public Result updateStatus(@RequestParam("status") int status, @RequestParam("id") int id) {
		return this.jobPostingService.updateStatus(status, id);

	}
	@PostMapping("/getByFilter")
	public Result getByFilter(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestBody JobAdFilter jobPostingFilter) {
		
		return jobPostingService.getByFilter(pageNo, pageSize, jobPostingFilter);
		
	}
}