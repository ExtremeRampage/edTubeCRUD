package org.krams.controller;

import org.krams.domain.Video;
import org.krams.dto.VideoListDto;
import org.krams.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoService service;
	
	@RequestMapping
	public String getVideosPage() {
		return "vids";
	}
	
	@RequestMapping(value="/records")
	public @ResponseBody VideoListDto getVideos() {
		System.out.println("meow");
		VideoListDto vidListDto = new VideoListDto();
		vidListDto.setVideos(service.readAll());
		return vidListDto;
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody Video get(@RequestBody Video vid) {
		return service.read(vid);
	}
	
	
	@RequestMapping(value="/tree", method=RequestMethod.GET)
	public @ResponseBody String getTree(
			@RequestParam String videoID) {

		Video existingVid = new Video();
		existingVid.setVideoID(videoID);
		
		return service.findTree(existingVid);
	}
	

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody Video create(
			@RequestParam String videoID,
			@RequestParam String jsTree) {

		Video newVid = new Video();
		newVid.setVideoID(videoID);
		newVid.setJsTree(jsTree);
		
		return service.create(newVid);
	}
//	
//	@RequestMapping(value="/update", method=RequestMethod.POST)
//	public @ResponseBody User update(
//			@RequestParam String username,
//			@RequestParam String firstName,
//			@RequestParam String lastName,
//			@RequestParam Integer role) {
//
//		Role existingRole = new Role();
//		existingRole.setRole(role);
//		
//		User existingUser = new User();
//		existingUser.setUsername(username);
//		existingUser.setFirstName(firstName);
//		existingUser.setLastName(lastName);
//		existingUser.setRole(existingRole);
//		
//		return service.update(existingUser);
//	}
//	
//	@RequestMapping(value="/delete", method=RequestMethod.POST)
//	public @ResponseBody Boolean delete(
//			@RequestParam String username) {
//
//		User existingUser = new User();
//		existingUser.setUsername(username);
//		
//		return service.delete(existingUser);
//	}
}
