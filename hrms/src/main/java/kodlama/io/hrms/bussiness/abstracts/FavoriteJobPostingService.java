package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.FavoriteJobPosting;

public interface FavoriteJobPostingService {

	
	public DataResult<List<FavoriteJobPosting>> getAll();
	Result add(int candidateId, int jobPostingId);
}
