package hmos9c.test.repository;

import hmos9c.test.data.Person;

public interface PersonRepository {

  Person selectById(String id);

  void insert(Person person);

}
