package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	public Person getPerson(int id) {
		return  (Person) personRepository.findOne((long) id);
	}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public List<Person> getAllPerson() {
		return  (List<Person>) personRepository.findAll() ;
	}
	public Person findById(int id) {
		return personRepository.findOne((long) id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}

}
