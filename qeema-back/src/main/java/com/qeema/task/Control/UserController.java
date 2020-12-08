package com.qeema.task.Control;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qeema.task.Model.Login;
import com.qeema.task.Model.User;
import com.qeema.task.Service.Login_Service;
import com.qeema.task.Service.Registration_Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "UserControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserController {
	 @Autowired
		Registration_Service service;
	 @Autowired
	 	Login_Service service1;
	 
	 
	 
	@RequestMapping("/login")
	public UserDetails login(@RequestBody User user) throws UsernameNotFoundException {
		
		UserDetails details=service.loadUserByUsername(user.getEmail());
			Login login=new Login();
			login.setEmail(user.getEmail());
			service1.saveOrUpdate(login);
		return details;
	}
	
	
	
	
	
	
	
	@ApiOperation("delecte Login seesion with specific user")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserController.class)})
	@RequestMapping("api/log/{email}")
	public void logout(@PathVariable("email") String email)
	{
		 List<Login> Logins=new ArrayList<>();

		service1.getByEmails(email).forEach(Logins::add);
		for (Login e: Logins)
		service1.delete(e.getSession_Id());
	//	service1.deletebymail(email);
	}
	
	
	
	@ApiOperation("delecte Login seesion with specific user")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserController.class)})
	@RequestMapping("/delete")
	public void delete( int id )
	{
//		 List<Login> Logins=new ArrayList<>();
//
//		service1.getByEmails(user.getEmail()).forEach(Logins::add);
//		for (Login e: Logins)
//		service1.delete(e.getSession_Id());
		
		service1.delete(id);
	}
	
	
	

}
