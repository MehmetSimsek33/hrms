package kodlama.io.hrms.bussiness.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateCheckServices
{
	boolean checkIfRealPerson(Candidate candidates);
}
