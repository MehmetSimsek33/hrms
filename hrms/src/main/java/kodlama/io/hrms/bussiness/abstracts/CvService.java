package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dto.CvDto;

public interface CvService {
	
	DataResult<List<CvDto>> getAllCvDto();
	DataResult<CvDto> getByCvDto(int id);
	DataResult<Cv> getByCvId(int id);
	DataResult<List<Cv>> getAll();
	Result add(Cv cv);
	Result update(Cv cv);

	public Result updateGithub(String gitHubAddress, int cvId);
	public Result deleteGithub(int cvId);
	
	public Result updateLinkedln(String linkedlnAddress, int cvId);
	public Result deleteLinkedln(int cvId);
}