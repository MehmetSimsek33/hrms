package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dto.CvDetailDto;
import kodlama.io.hrms.entities.dto.CvDto;

public interface CvService {
	
	DataResult<List<CvDto>> getAllCvDto();

	DataResult<List<CvDetailDto>> getDetailDtoById(int id);

	DataResult<List<Cv>> getAll();
	Result add(CvDto cv);
}