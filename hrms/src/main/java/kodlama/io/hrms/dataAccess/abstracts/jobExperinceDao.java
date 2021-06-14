package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobExperince;

public interface jobExperinceDao extends JpaRepository<JobExperince, Integer> {

}
