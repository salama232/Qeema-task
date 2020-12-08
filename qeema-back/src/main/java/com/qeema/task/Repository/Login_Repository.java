package com.qeema.task.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.qeema.task.Model.Login;

@Repository

public interface Login_Repository extends CrudRepository <Login,Integer> {
	public List<Login> findAll();
	public List<Login> findByEmail(String Email);
	public void deleteByEmail(String Email);

}
