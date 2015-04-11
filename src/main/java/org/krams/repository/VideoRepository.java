package org.krams.repository;

import org.krams.domain.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
	
	Video findByVideoID(String videoID);
}
