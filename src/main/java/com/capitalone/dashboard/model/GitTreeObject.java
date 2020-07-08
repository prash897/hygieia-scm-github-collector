package com.capitalone.dashboard.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "git_tree_object")
public class GitTreeObject extends BaseModel{

	private String mode;
	
	private ObjectId repoObjectId;
	
	private String repoBranch;
	
	@Indexed(unique = true)
	private String path ;
	private Long size;
	
	private String type;
	
	private String sha;
	private String url;
	
	
	
	public String getRepoBranch() {
		return repoBranch;
	}
	public void setRepoBranch(String repoBranch) {
		this.repoBranch = repoBranch;
	}
	public ObjectId getRepoObjectId() {
		return repoObjectId;
	}
	public void setRepoObjectId(ObjectId repoObjectId) {
		this.repoObjectId = repoObjectId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
