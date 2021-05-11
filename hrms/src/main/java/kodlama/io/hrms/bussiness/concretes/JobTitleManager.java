package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.JobTitleService;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.job_titles;
@Service
public class JobTitleManager implements JobTitleService {
	@Autowired
	private JobTitleDao jobtitleDao;
	
	@Override
	public List<job_titles> getAll() {
			return this.jobtitleDao.findAll();
	}

}
