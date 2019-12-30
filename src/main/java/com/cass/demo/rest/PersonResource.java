package com.cass.demo.rest;

import com.cass.demo.dbo.Person;
import com.cass.demo.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author abhishek.k
 */
@RestController
@RequestMapping("/person")
public class PersonResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);

    @Autowired
    PersonService personService;

    @PostMapping
public ResponseEntity<Person> insert(@Valid @RequestBody Person person) throws IOException
{
    LOGGER.info("Add person to person table.");
    return ResponseEntity.ok().body(personService.insertPerson(person));
}

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        LOGGER.info("Get all person request start.");
        return ResponseEntity.ok().body(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") long id) {
        LOGGER.debug("Get person detail by id : {} ", id);
        return ResponseEntity.ok().body(personService.getPerson(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        LOGGER.debug("Update person by person : {} ", person);
        return ResponseEntity.ok().body(personService.updatePerson(person));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        LOGGER.debug("Delete person by id : {} ", id);
        personService.deletePerson(id);
    }
}
