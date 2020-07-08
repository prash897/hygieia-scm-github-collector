package com.capitalone.dashboard.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capitalone.dashboard.service.GitService;

@RestController
public class GitController {

	@Autowired
	GitService gitService;
	
	@RequestMapping(value = "/git/showcase/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Object>> getShowcase(){
		return  ResponseEntity.ok(gitService.getShowcase());
	}
	
	
}
