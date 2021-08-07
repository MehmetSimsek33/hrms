package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobPosting;
import kodlama.io.hrms.entities.dto.JobAdFilter;

public interface JobPostingService {
	
	Result add(JobPosting jobPosting);

	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getByStatus(boolean status);

	DataResult<List<JobPosting>> getAllStatusAndDate(boolean status);

	DataResult<List<JobPosting>> getByStatusAndEmployerId(boolean status, int employerId);

	Result Update(JobPosting jobPosting);
	
	Result updateStatus(int status,int id);
	 DataResult<List<JobPosting>> getByFilter(int pageNo, int pageSize, JobAdFilter jobPostingFilter);


}