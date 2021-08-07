package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.TempEmployer;

public interface TempEmployerDao extends JpaRepository<TempEmployer,Integer > {

	TempEmployer findById(int id);
}
