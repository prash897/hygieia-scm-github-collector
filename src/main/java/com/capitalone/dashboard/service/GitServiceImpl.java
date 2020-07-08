package com.capitalone.dashboard.service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.capitalone.dashboard.collector.DefaultGitHubClient;
import com.capitalone.dashboard.domain.Content;
import com.capitalone.dashboard.misc.HygieiaException;
import com.capitalone.dashboard.model.GitHub;
import com.capitalone.dashboard.model.GitTreeObject;
import com.capitalone.dashboard.repository.GitHubRepository;
import com.capitalone.dashboard.repository.GitTreeObjectRepository;

@Component
public class GitServiceImpl implements GitService {
    
	@Autowired
	GitTreeObjectRepository<GitTreeObject>  gitTreeObjectRepository;
	
	@Autowired
	DefaultGitHubClient defaultGitHubClient;
	
	@Autowired
	GitHubRepository gitHubRepository;
	
	
	@Override
	public List<Object> getShowcase(){
    	List<Object> data = new ArrayList<Object>();
    	
    	List<GitTreeObject> gitTreeObjects = gitTreeObjectRepository.findByPathLike(".tmpl");
    	gitTreeObjects.parallelStream().forEach(obj -> {
    		GitHub repo = getRepo(obj.getRepoObjectId());
    		String tmpl = getFileAsString(repo, obj.getPath());
    		
    		if(tmpl!=null) {
    			Content content = getContent(tmpl);
    			data.add(content);
    		}
    	});
    	
    	return data;
    }
    
    @Override
	public List<Object> getContentShowcase(){
    	List<Object> data = new ArrayList<Object>();
    	
    	return data;
    }
    
    private GitHub getRepo(ObjectId objectId) {
    	return gitHubRepository.findOne(objectId);
    }
    
    private String getFileAsString(GitHub repo, String path) {
    	String file = null;
    	try {
			JSONObject jsonObject = (JSONObject) defaultGitHubClient.getContent(repo, path);
			
			
		} catch (MalformedURLException | HygieiaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return file;
    }
    
    private Content getContent(String xml) {
    	Content content = new Content();
    	
    	 try {
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse(xml);
             doc.getDocumentElement().normalize();
             System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
             
             
             
             NodeList nList = doc.getElementsByTagName("content");
             System.out.println("----------------------------");
             
             for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) nNode;
                   System.out.println("Student roll no : " 
                      + eElement.getAttribute("rollno"));
                   System.out.println("First Name : " 
                      + eElement
                      .getElementsByTagName("firstname")
                      .item(0)
                      .getTextContent());
                   System.out.println("Last Name : " 
                      + eElement
                      .getElementsByTagName("lastname")
                      .item(0)
                      .getTextContent());
                   System.out.println("Nick Name : " 
                      + eElement
                      .getElementsByTagName("nickname")
                      .item(0)
                      .getTextContent());
                   System.out.println("Marks : " 
                      + eElement
                      .getElementsByTagName("marks")
                      .item(0)
                      .getTextContent());
                }
             }
          } catch (Exception e) {
             e.printStackTrace();
          }
    	
    	
    	return content;
    	
    }
}
