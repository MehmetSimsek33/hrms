package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employe;

public interface EmployeDao extends JpaRepository<Employe, Integer> {

	Employe getEmployesById(int id);
} 