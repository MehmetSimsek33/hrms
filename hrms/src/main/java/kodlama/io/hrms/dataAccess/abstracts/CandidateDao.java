package kodlama.io.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.User;

public interface CandidateDao extends JpaRepository<Candidate, Integer>
{   
	User getByidentificationNumber(String nationalIdentity);
	
	Candidate getById(int id);

}
