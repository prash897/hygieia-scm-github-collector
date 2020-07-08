package com.capitalone.dashboard.domain;

import java.util.ArrayList;
import java.util.List;

public class Content {
	
	private String heading ;
	private String thumbnail;
	private String desc;
	
	private String pdfSrc;
	
	private String endNote;
	
	private List<SubContent> subContents = new ArrayList<>();
	
	
	
	public String getHeading() {
		return heading;
	}




	public void setHeading(String heading) {
		this.heading = heading;
	}




	public String getThumbnail() {
		return thumbnail;
	}




	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}




	public String getDesc() {
		return desc;
	}




	public void setDesc(String desc) {
		this.desc = desc;
	}




	public String getPdfSrc() {
		return pdfSrc;
	}




	public void setPdfSrc(String pdfSrc) {
		this.pdfSrc = pdfSrc;
	}




	public String getEndNote() {
		return endNote;
	}




	public void setEndNote(String endNote) {
		this.endNote = endNote;
	}




	public List<SubContent> getSubContents() {
		return subContents;
	}




	public void setSubContents(List<SubContent> subContents) {
		this.subContents = subContents;
	}




	private class SubContent{
		
	private String subHeading;
	
	private String imageSrc;
	
	private String codeSrc;

	public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getCodeSrc() {
		return codeSrc;
	}

	public void setCodeSrc(String codeSrc) {
		this.codeSrc = codeSrc;
	}
	
	
	}
	
	
	

}
