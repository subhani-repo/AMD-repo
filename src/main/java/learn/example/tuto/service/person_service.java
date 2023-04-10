package learn.example.tuto.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import learn.example.tuto.entity.perosn_entity;
import learn.example.tuto.entity.personPojo;
import learn.example.tuto.exceptions.UserDefinedException;

public interface person_service {

	public List<perosn_entity> save(List<perosn_entity> s); 
	
	public List<perosn_entity> getall();
	
	public List<personPojo> getall2();

	public perosn_entity getbyid(Integer id) throws UserDefinedException;
}
