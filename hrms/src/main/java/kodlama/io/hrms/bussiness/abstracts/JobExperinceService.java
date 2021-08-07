package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobExperince;

import kodlama.io.hrms.entities.dto.jobExperinceDto;

public interface JobExperinceService {

	DataResult<List<jobExperinceDto>> getalljobExperinceDto();
	public DataResult<List<JobExperince>> getByCvId(int cvId);
	Result add(JobExperince jobExperince); 
	public Result deleteJobExperince(int jobExperinceId);
}
