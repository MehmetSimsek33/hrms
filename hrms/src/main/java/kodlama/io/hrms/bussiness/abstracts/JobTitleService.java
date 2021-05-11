package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.job_titles;

public interface JobTitleService 
{
	List<job_titles> getAll();
}
