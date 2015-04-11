package org.krams.service;

import java.util.List;
import org.krams.domain.Video;
import org.krams.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	public Video create(Video vid) {
		vid.setVideoID("NULL");
		
		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		return videoRepository.save(vid);
	}
	
	public Video read(Video vid) {
		return vid;
	}
	
	public List<Video> readAll() {
		return videoRepository.findAll();
	}
	
	public Video update(Video vid) {
		Video existingUser = videoRepository.findByVideoID(vid.getVideoID());
		
		if (existingUser == null) {
			return null;
		}
		
		existingUser.setVideoID(vid.getVideoID());
		existingUser.setJsTree(vid.getJsTree());
		
		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		return videoRepository.save(existingUser);
	}
	
	public Boolean delete(Video vid) {
		Video existingUser = videoRepository.findByVideoID(vid.getVideoID());
		
		if (existingUser == null) {
			return false;
		}
		
		// We must delete both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)

		videoRepository.delete(existingUser);
		return true;
	}
	
	public String findTree(Video vid) {
		Video existingUser = videoRepository.findByVideoID(vid.getVideoID());
		
		if (existingUser == null) {
			return "NULL";
		}
		
		// We must delete both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)

		return existingUser.getJsTree();
	}
}
