package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;



import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.User;


public interface UserService {
	
	DataResult<List<User>> getAll();
}
