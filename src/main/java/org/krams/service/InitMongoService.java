package org.krams.service;

import java.util.UUID;

import org.krams.domain.Role;
import org.krams.domain.User;
import org.krams.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

//import com.mongodb.DBObject;
//import com.mongodb.util.JSON;

/**
 * Service for initializing MongoDB with sample data using {@link MongoTemplate}
 */
public class InitMongoService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void init() {
		// Drop existing collections
		mongoTemplate.dropCollection("role");
		mongoTemplate.dropCollection("user");
		mongoTemplate.dropCollection("video");

		// Create new records
		Role adminRole = new Role();
		adminRole.setId(UUID.randomUUID().toString());
		adminRole.setRole(1);
		
		Role userRole = new Role();
		userRole.setId(UUID.randomUUID().toString());
		userRole.setRole(2);
		
		User john = new User();
		john.setId(UUID.randomUUID().toString());
		john.setFirstName("John");
		john.setLastName("Smith");
		john.setPassword("21232f297a57a5a743894a0e4a801fc3");
		john.setRole(adminRole);
		john.setUsername("john");
		
		User jane = new User();
		jane.setId(UUID.randomUUID().toString());
		jane.setFirstName("Jane");
		jane.setLastName("Adams");
		jane.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		jane.setRole(userRole);
		jane.setUsername("jane");
		
		// Insert to db
		mongoTemplate.insert(john, "user");
		mongoTemplate.insert(jane, "user");
		mongoTemplate.insert(adminRole, "role");
		mongoTemplate.insert(userRole, "role");
		
		Video test = new Video();
		test.setVideoID("5FFkDV2NKEY");
		test.setJsTree("{'id':1,'text':'Root node','children':[{'id':2,'text':'Child node 1'},{'id':3,'text':'Child node 2'}]}");
		
		Video test2 = new Video();
		test2.setVideoID("6EEjDV2NKEY");
		test2.setJsTree("{'id':1,'text':'Root node','children':[{'id':2,'text':'Child node 1'},{'id':3,'text':'Child node 2'}]}");
		
		mongoTemplate.insert(test,"video");
		mongoTemplate.insert(test2,"video");
		
//		DBObject dbObject = (DBObject) JSON
//				.parse("{'id':1,'text':'Root node','children':[{'id':2,'text':'Child node 1'},{'id':3,'text':'Child node 2'}]}");
//		System.out.println(dbObject);
//		mongoTemplate.insert(dbObject,"happyTown");
	}
}
