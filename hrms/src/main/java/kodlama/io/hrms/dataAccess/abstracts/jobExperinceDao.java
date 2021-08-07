package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobExperince;

public interface jobExperinceDao extends JpaRepository<JobExperince, Integer> {
	List<JobExperince> findByCvId(int id);
}
