package com.qeema.task.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qeema.task.Model.User;

@Repository
public interface Registration_Repository extends CrudRepository<User,Integer> {
	public List<User> findAll();
	Optional<User> findByEmail(String Email);
}
