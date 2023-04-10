package learn.example.tuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learn.example.tuto.entity.perosn_entity;
import learn.example.tuto.entity.personPojo;
import learn.example.tuto.exceptions.UserDefinedException;
import learn.example.tuto.service.person_service;

@RestController
public class person_controller {
    @Autowired
	public person_service serv;
    
    @PostMapping("save")
    public void save(@RequestBody List<perosn_entity> s) {
    	List<perosn_entity> e= serv.save(s);
    		
    }
    @GetMapping("getall")
    public List<perosn_entity> getall() {
    	List<perosn_entity> alldata =(List<perosn_entity>) serv.getall();
    	return alldata;
    }
    @GetMapping("getall2")
    public List<personPojo> getall2() {
    	List<personPojo> alldata =serv.getall2();
    	return alldata;
    }
    
    @GetMapping("getbyid/{id}")
    public perosn_entity getbyid(@PathVariable("id") Integer id) throws UserDefinedException {
    	perosn_entity GetById =serv.getbyid(id);
    	return GetById;
    }
}
