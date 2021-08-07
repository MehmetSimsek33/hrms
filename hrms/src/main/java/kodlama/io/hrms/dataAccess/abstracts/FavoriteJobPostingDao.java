package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.FavoriteJobPosting;

public interface FavoriteJobPostingDao extends JpaRepository<FavoriteJobPosting, Integer>{

}
