package com.code.restTamplate.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import models.ApiReponseObject;
import models.ModelApiResponse;

@RestController
public class MainController {
	
	@Autowired
	private RestTemplate restTamplate;
	
	@RequestMapping(value = "/template/results")
	   public List<ApiReponseObject> getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<ModelApiResponse> entity = new HttpEntity<ModelApiResponse>(headers);
	      
	      ModelApiResponse response =restTamplate.exchange(
	         "https://pokeapi.co/api/v2/pokemon?limit=3", HttpMethod.GET, entity, ModelApiResponse.class)
	    		  .getBody();
	      
	      return response.getResults();
	   }
}
