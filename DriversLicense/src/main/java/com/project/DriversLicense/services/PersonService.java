package com.project.DriversLicense.services;

import com.project.DriversLicense.models.License;
import com.project.DriversLicense.models.Person;
import com.project.DriversLicense.repositories.PersonRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class PersonService{
	// Member variables / service initializations go here

	private PersonRepository personRepository;

	@Autowired

	private LicenseService licenseService;

	public PersonService(PersonRepository personRepository){

		this.personRepository = personRepository;

	}	

	public void create(Person person){personRepository.save(person);}

	public void update(Person person){personRepository.save(person);}

	public void destroy(long id){personRepository.delete(id);}

	

	public ArrayList<Person> all(){

		return (ArrayList<Person>) personRepository.findAll();

	}

	public Person findByIndex(long id){
		return personRepository.findOne(id);
	}

	

	public ArrayList<Person> noLicense(){ // Please let there be a prettier way.

		ArrayList<Person> people    = this.all();

		ArrayList<License> licenses = licenseService.all();
	
		for(int i=0;i<people.size();i++){
			for(int j=0;j<licenses.size();j++){ // if they have licence remove since they have a license.
				if(people.get(i).getId() == licenses.get(j).getPerson().getId()){

					people.remove(i);

				}

			}

		}

		return people;

	}

	// public Object License() {
	// 	return null;
	// }

}





