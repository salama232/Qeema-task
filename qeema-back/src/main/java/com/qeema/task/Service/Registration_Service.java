package com.qeema.task.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.qeema.task.Model.User;
import com.qeema.task.Repository.Registration_Repository;
import com.qeema.task.Model.MyUserDetails;


@Service
public class Registration_Service  implements UserDetailsService {
	@Autowired
    private Registration_Repository repository;
	   
	    public List<User> findAll() {

	    	List<User> Users=new ArrayList<>();
			 repository.findAll().forEach(Users::add);
			 return Users;
	    }
	    
	public User getRegistrationById(int id) {  
		    return repository.findById(id).get();  
    }  
	
public User getRegistrationByEmail(String Email) {  
	    return repository.findByEmail(Email).get();  
} 


@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = repository.findByEmail(email);

    user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));

    return user.map(MyUserDetails::new).get();
}
	

	public void saveOrUpdate(User Users){  
		
		    	repository.save(Users);  
		    	
	}  
	public void delete(int id){  
		
		    	repository.deleteById(id);  
	}

  
	  

}
