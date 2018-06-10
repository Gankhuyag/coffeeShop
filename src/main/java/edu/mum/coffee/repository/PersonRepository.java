package edu.mum.coffee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	public List<Person> findByEmail(String email);
	
}
