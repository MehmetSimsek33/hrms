package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.job_titles;

public interface JobTitleDao extends JpaRepository<job_titles, Integer>{

}
