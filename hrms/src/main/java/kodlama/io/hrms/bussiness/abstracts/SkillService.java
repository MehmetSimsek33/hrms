package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.dto.SkillDto;

public interface SkillService {

	DataResult<List<Skill>> getAll();
	DataResult<List<SkillDto>> getallSkillDto();
}
