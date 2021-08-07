package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.JobTitleService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	@Autowired
	private JobTitleDao jobtitleDao;


	@Override
	public DataResult<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobTitle>>(this.jobtitleDao.findAll());
	}



}
