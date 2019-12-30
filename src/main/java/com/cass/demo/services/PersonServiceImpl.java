package com.cass.demo.services;

import com.cass.demo.dbo.Person;
import com.cass.demo.dto.Producer;
import com.cass.demo.errorhandler.PersonNotFoundException;
import com.cass.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author abhishek.k
 */
@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    Producer producer;

    @Override
    public Person insertPerson(Person person) {
        LOGGER.debug("Adding person to person table started. ");
        producer.sendMessage(person.toString());
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        LOGGER.info("Getting all person request started.");
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(long id) {
        LOGGER.debug("Getting person detail started.  id : {} ", id);
        boolean count = personRepository.existsById(id);
        if (!count) {
            throw new PersonNotFoundException("Person not found with Invalid id : " + id);
        }
        producer.sendMessage(personRepository.findById(id).toString());
        return personRepository.findById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        LOGGER.debug("Update person started by person : {} ", person);
        personRepository.deleteById(person.getId());
        return personRepository.save(person);

    }

    @Override
    public void deletePerson(long id) {
        LOGGER.debug("Delete person started id : {} ", id);
        personRepository.deleteById(id);
    }
}
