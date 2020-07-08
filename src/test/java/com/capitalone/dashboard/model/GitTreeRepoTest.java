package com.capitalone.dashboard.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.capitalone.dashboard.repository.GitTreeObjectRepository;

public class GitTreeRepoTest {

	@InjectMocks GitTreeObjectRepository<GitTreeObject> gitTreeObjectRepository;
	
	
	
	@Test
	public void testTmplExist() {
		List<GitTreeObject> trees = gitTreeObjectRepository.findByPathLike("*tmpl");
		
		assertTrue(trees.size() > 0);
				
	}
}
