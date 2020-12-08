package com.qeema.task.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qeema.task.Model.Login;
import com.qeema.task.Service.Login_Service;
import com.qeema.task.Service.Registration_Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "LoginControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api")
public class LoginControl {
	 @Autowired
	 Login_Service service;
	Registration_Service servicer;

	
	  
	 
	 @RequestMapping("/all/login")
	 public List<Login> getall()
	 {

		 return service.findAll();
			 
	 }
	 
	 @ApiOperation("Gets Login seesion with specific id")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Login.class)})
	 @RequestMapping("/loginsession/{id}")
	 public Login getloginseesion(@PathVariable("id") int id)
	 {

		 return service.getLoginById(id); 
			 
	 }
	 
	 
	 @ApiOperation("Delete Login seesion with specific id")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Login.class)})
	 @DeleteMapping("/login/{id}")  
	 private void deleteLoginseesion(@PathVariable("id") int id)   
	 {  
	  service.delete(id);  
	 }
	 
	 @ApiOperation("Delete Login seesion with specific id")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Login.class)})
	 @DeleteMapping("/login/{email}")  
	 private void deleteseesionbyemail(@PathVariable("email") String email)   
	 {  
	  service.deletebymail(email);  
	 }
	 
	 @ApiOperation("insert new Login seesion")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Login.class)})
	 @PostMapping("/Loginsession")  
	 private int saveLoginsession(@RequestBody Login login)   
	 {  
	 service.saveOrUpdate(login);  
	 return login.getSession_Id();  
	 } 
	 
	 
}
