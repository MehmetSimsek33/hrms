package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.JobTitle;

public interface JobTitleService 
{
	List<JobTitle> getAll();
}
