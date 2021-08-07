package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.FavoriteJobPostingService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.FavoriteJobPostingDao;
import kodlama.io.hrms.dataAccess.abstracts.JobPostingDao;
import kodlama.io.hrms.entities.concretes.FavoriteJobPosting;

@Service
public class FavoriteJobPostingManger implements FavoriteJobPostingService {
	
	FavoriteJobPostingDao favoriteJobPostingDao;
	CandidateDao candidateDao;
	JobPostingDao jobPostingDao;
	public FavoriteJobPostingManger(FavoriteJobPostingDao favoriteJobPostingDao, CandidateDao candidateDao,
			JobPostingDao jobPostingDao) {
		super();
		this.favoriteJobPostingDao = favoriteJobPostingDao;
		this.candidateDao = candidateDao;
		this.jobPostingDao = jobPostingDao;
	}

	
	@Override
	public Result add(int candidateId, int jobPostingId) 
	{
		FavoriteJobPosting favoriteJobPosting = new FavoriteJobPosting();
		
		favoriteJobPosting.setCandidate(this.candidateDao.getById(candidateId));
		favoriteJobPosting.setJobPosting(this.jobPostingDao.getById(jobPostingId));
		
		this.favoriteJobPostingDao.save(favoriteJobPosting);
		
		   return new SuccesResult("Basarılı");
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getAll() {
	
		return new SuccessDataResult<List<FavoriteJobPosting>>(this.favoriteJobPostingDao.findAll());
	}
	
}
