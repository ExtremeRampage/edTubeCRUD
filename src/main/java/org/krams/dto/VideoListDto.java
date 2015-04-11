package org.krams.dto;

import java.util.List;

import org.krams.domain.Video;

public class VideoListDto {

	private List<Video> vids;

	public List<Video> getVideos() {
		return vids;
	}

	public void setVideos(List<Video> users) {
		this.vids = users;
	}
}
