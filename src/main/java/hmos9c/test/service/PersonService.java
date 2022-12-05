package hmos9c.test.service;

import hmos9c.test.repository.PersonRepository;
import hmos9c.test.data.Person;

import java.util.UUID;

public class PersonService {

  private PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person get(String id) {
    Person person = personRepository.selectById(id);
    if (person != null) {
      return person;
    } else {
      throw new IllegalArgumentException("Person not found");
    }
  }

  public Person register(String name){
    var person = new Person(UUID.randomUUID().toString(), name);
    personRepository.insert(person);
    return person;
  }
}
