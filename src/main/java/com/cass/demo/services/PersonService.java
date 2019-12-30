package com.cass.demo.services;
import com.cass.demo.dbo.Person;
import java.util.List;

/**
 * @author abhishek.k
 */
public interface PersonService {

    Person insertPerson(Person person);

    List<Person> getAll();

    Person getPerson(long id);

    Person updatePerson(Person person);

    void deletePerson(long id);
}
