package com.qeema.task.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qeema.task.Model.User;
import com.qeema.task.Service.Registration_Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Controller
@RestController
@Api(value = "RegistrationControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api")
public class RegistrationControl {
	

	
	
  
	 @Autowired
	Registration_Service service;
	 
	 
	 
	 @MessageMapping("/regest")
	 @SendTo("/topic/registration")
   public List<User> registration() throws Exception {
	        Thread.sleep(1000); // simulated delay
	        List<User> users=service.findAll();
	        return users;
    }

	 @MessageMapping("/log")
	 @SendTo("/topic/registration")
   public String registrations(String email) throws Exception {
	        Thread.sleep(1000); 
	      System.out.println(email);

	        
	        return "ok";
    }



	 
	
	 

	 
	 
	 @ApiOperation("Gets all Registration Session")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = User.class)})
	 @RequestMapping("/all/Registration")
	 public List<User> getall()
	 {
		 return service.findAll();	 
	 }
	 	 
	 @ApiOperation("Gets Registration seesion with specific id")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = User.class)})
	 @RequestMapping("/Registration/{id}")
	 public User getRegistrationseesion(@PathVariable("id") int id)
	 {
		 return service.getRegistrationById(id); 	 
	 }
	 
	 
	 @ApiOperation("Delete Registration seesion with specific id")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = User.class)})
	 @DeleteMapping("/Registration/{id}")  
	 private void deleteRegistrationseesion(@PathVariable("id") int id)   
	 {  
	  service.delete(id);  
	 }
	 
	 
	 @ApiOperation("insert new Registration seesion")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = User.class)})
	 @PostMapping("/Registration")  
	 private int saveStudent(@RequestBody User User)   
	 {  
	 service.saveOrUpdate(User);  
	 return User.getId();  
	 } 
}
