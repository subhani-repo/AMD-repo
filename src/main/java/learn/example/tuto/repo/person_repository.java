package learn.example.tuto.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import learn.example.tuto.entity.perosn_entity;
import learn.example.tuto.entity.personPojo;

public interface person_repository extends JpaRepository<perosn_entity, Integer>{
	
	@Query(value="select date,email,pname from tuto.perosn_entity where isdeteled= 0", nativeQuery = true)
	public List<personPojo> getall2();

}
