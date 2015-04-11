package org.krams.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Video {
	
	@Id
	private String videoID;
	
	private String jsTree;

	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}

	public String getJsTree() {
		return jsTree;
	}

	public void setJsTree(String jsTree) {
		this.jsTree = jsTree;
	}

}
