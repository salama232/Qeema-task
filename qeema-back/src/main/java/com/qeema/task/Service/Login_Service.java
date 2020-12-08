package com.qeema.task.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qeema.task.Model.Login;
import com.qeema.task.Repository.Login_Repository;
@Service
public class Login_Service {
	
	@Autowired
    private Login_Repository repository;
	   
	    public List<Login> findAll() {

	    	List<Login> Logins=new ArrayList<>();
			 repository.findAll().forEach(Logins::add);
			 return Logins;
	    }
	public Login getLoginById(int id) {  
		    return repository.findById(id).get();  
    }  
	
	
	public void saveOrUpdate(Login login){  
		
		    	repository.save(login);  
		    	
	}  
	public void delete(int id){  
		
		    	repository.deleteById(id);  
	}  
	
	
	public void deletebymail(String email){  
		
    	repository.deleteByEmail(email);  
}  

	
	public List<Login> getByEmails(String Email) {  
	    List<Login> Logins=new ArrayList<>();
	    repository.findByEmail(Email).forEach(Logins::add);
		 return Logins;
}

}
