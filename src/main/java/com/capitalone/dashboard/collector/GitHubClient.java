package com.capitalone.dashboard.collector;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;

import com.capitalone.dashboard.misc.HygieiaException;
import com.capitalone.dashboard.model.Commit;
import com.capitalone.dashboard.model.GitHub;
import com.capitalone.dashboard.model.GitRequest;
import com.capitalone.dashboard.model.GitTreeObject;

/**
 * Client for fetching commit history from GitHub
 */
public interface GitHubClient {


	List<Commit> getCommits(GitHub repo, boolean firstRun, List<Pattern> commitExclusionPatterns) throws MalformedURLException, HygieiaException;
	
	List<GitTreeObject> getTree(GitHub repo, boolean firstRun, List<Pattern> commitExclusionPatterns) throws MalformedURLException, HygieiaException;

    List<GitRequest> getPulls(GitHub repo, String status, boolean firstRun, Map<Long, String> prMap) throws MalformedURLException, HygieiaException;

    List<GitRequest> getIssues(GitHub repo, boolean firstRun) throws MalformedURLException, HygieiaException;
    
    JSONObject getContent(GitHub repo, String sha) throws MalformedURLException, HygieiaException;

}
