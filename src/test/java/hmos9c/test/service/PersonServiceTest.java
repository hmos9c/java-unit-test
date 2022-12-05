package hmos9c.test.service;

import hmos9c.test.data.Person;
import hmos9c.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
    @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  private PersonService personService;

  @BeforeEach
  void setUp() {
    personService = new PersonService(personRepository);
  }

  @Test
  void testGetPersonNotFound() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      personService.get("not found");
    });
  }

  @Test
  void testGetPersonSuccess() {
    // menambah behavior ke mock object
    Mockito.when(personRepository.selectById("eko"))
        .thenReturn(new Person("eko", "Eko"));

    var person = personService.get("eko");

    Assertions.assertNotNull(person);
    Assertions.assertEquals("eko", person.getId());
    Assertions.assertEquals("Eko", person.getName());
  }

  @Test
  void testRegisterSuccess() {
    var person = personService.register("Eko");
    Assertions.assertNotNull(person);
    Assertions.assertEquals("Eko", person.getName());
    Assertions.assertNotNull(person.getId());

    Mockito.verify(personRepository, Mockito.times(1))
        .insert(new Person(person.getId(), "Eko"));
  }
}
