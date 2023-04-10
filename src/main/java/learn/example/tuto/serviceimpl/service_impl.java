
package learn.example.tuto.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import learn.example.tuto.entity.perosn_entity;
import learn.example.tuto.entity.personPojo;
import learn.example.tuto.exceptions.UserDefinedException;
import learn.example.tuto.repo.person_repository;
import learn.example.tuto.service.person_service;

@Service
public class service_impl implements person_service {
	@Autowired
	private person_repository repo;
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private static RestTemplate restTemplate;
	@Transactional
	
	public String save1(String pid) {

		 Query query = null;
		String sql = "delete from tuto.perosn_entity where pid=:pid";
		 query = entityManager.createNativeQuery(sql, Tuple.class);
		 query.setParameter("pid", pid);
		 int existingDataDeleted = query.executeUpdate();
		 System.out.println("existingDataDeleted=" + existingDataDeleted);
		entityManager.createQuery(sql).executeUpdate();
		return "success";
	}

	
	public List<perosn_entity> save(List<perosn_entity> pid) {
		  List<perosn_entity> list= repo.saveAll(pid);
		  return list;
	}
	
	@Override
	public List<perosn_entity> getall() {
		List<perosn_entity> alldata = repo.findAll();
		return alldata;
	}

	@Override
	public List<personPojo> getall2() {
		List<personPojo> alldata = repo.getall2();
		return alldata;
	}

	@Override
	public perosn_entity getbyid(Integer id) throws UserDefinedException {
		perosn_entity GetById = null;
		GetById = this.repo.findById(id).orElseThrow(() -> new UserDefinedException("person not found ra bbai"));
		return GetById;
	}

	/*
	
	public static void main(String[] args) throws JsonProcessingException {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	List<Map<String, Object>> requestBodyList = new ArrayList<>();
	
	    Map<String, Object> requestBody1 = new HashMap<>();
		requestBody1.put("email", "obama@example.com");
		requestBody1.put("date", "1995-01-31");
		requestBody1.put("pname", "obama");
		requestBody1.put("psal", "12300000.99");
		
		Map<String, Object> requestBody2 = new HashMap<>();
		requestBody2.put("email", "gandhi@example.com");
		requestBody2.put("date", "1947-01-31");
		requestBody2.put("pname", "gandhi");
		requestBody2.put("psal", "19470000.99");
		
		requestBodyList.add(requestBody1);
		requestBodyList.add(requestBody2);
		
		HttpEntity<List<Map<String, Object>>> request = new HttpEntity<>(requestBodyList, headers);
		System.out.println("request--"+request);
		String url = "http://localhost:8080/save";
		ResponseEntity<JsonNode> result = restTemplate.exchange(url, HttpMethod.POST,request,JsonNode.class);

		System.out.println("result--"+result);
		
}
	*/
	/*public static ResponseEntity<JsonNode> postingEnrty(perosn_entity req) throws JsonProcessingException {
		 perosn_entity tcsPostingEntryRequest = req;
		String GET_ALL_USERS_API_SAVE="http://localhost:8080/save";
		 HttpHeaders headers = new HttpHeaders();
		 
	
	HttpEntity<perosn_entity> httpEntity = new HttpEntity<>(req, headers);
	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8080/save");
	String uriBuilder = builder.build().encode().toUriString();
	ObjectMapper om=new ObjectMapper();
	 om.writeValueAsString(req);
	 
	ResponseEntity<JsonNode> result = restTemplate.exchange(uriBuilder, HttpMethod.POST,httpEntity,JsonNode.class);
	JsonNode json = result.getBody();
	 System.out.println(result.getStatusCodeValue());
	return result;
	 
}
*/

public static void main(String[] args) {
	RestTemplate restTemplate = new RestTemplate();

	String url = "https://example.com/api/endpoint?key1=value1&key2=value2";
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	HttpEntity<String> requestEntity = new HttpEntity<>(headers);

	ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
	String responseBody = responseEntity.getBody();
}
	

	
}