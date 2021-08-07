package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlama.io.hrms.bussiness.abstracts.JobPostingService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPostingDao;
import kodlama.io.hrms.entities.concretes.JobPosting;
import kodlama.io.hrms.entities.dto.JobAdFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Service
public class JobPostingManager implements JobPostingService {

	@Autowired
	JobPostingDao jobPostingDao;

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccesResult("Başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {

		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
	}

	@Override
	public DataResult<List<JobPosting>> getByStatus(@RequestParam("status") boolean status) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatus(status));
	}

	@Override
	public DataResult<List<JobPosting>> getAllStatusAndDate(boolean status) {
		Sort sort = Sort.by(Sort.Direction.ASC, "lastDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatus(status, sort));
	}

	@Override
	public DataResult<List<JobPosting>> getByStatusAndEmployerId(boolean status, int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatusAndEmployerId(status, employerId));
	}

	@Override
	public Result Update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccesResult();
	}

	@Override
	public Result updateStatus(int status, int id) {
		this.jobPostingDao.updateStatus(status, id);
		return new SuccesResult();
	}

	@Override
	public DataResult<List<JobPosting>> getByFilter(int pageNo, int pageSize, JobAdFilter jobPostingFilter) {
		  Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		  return new SuccessDataResult<List<JobPosting>>
		  (this.jobPostingDao.getByFilter(jobPostingFilter, pageable).getContent(), this.jobPostingDao.getByFilter(jobPostingFilter,pageable).getTotalElements()+"");
	}

	
}