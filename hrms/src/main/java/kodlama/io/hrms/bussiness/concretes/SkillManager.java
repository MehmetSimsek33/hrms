package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.SkillDao;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.dto.SchoolDto;
import kodlama.io.hrms.entities.dto.SkillDto;
@Service
public class SkillManager implements SkillService {
	@Autowired
	SkillDao skildao;
	@Override
	public DataResult<List<Skill>> getAll() {
		
		
		return new SuccessDataResult<List<Skill>>(this.skildao.findAll());
	}
	@Override
	public DataResult<List<SkillDto>> getallSkillDto() {
		return new SuccessDataResult<List<SkillDto>>(ModelMapperUtils.toList(
				this.skildao.findAll(),
				SkillDto.class)
				);
	}

}
