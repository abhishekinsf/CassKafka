package com.cass.demo.repository;

import com.cass.demo.dbo.Person;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author abhishek.k
 */
@Repository
@EntityScan(basePackages = {"com"})
public interface PersonRepository extends CassandraRepository<Person,Long> {

    Person save(Person person);

    List<Person> findAll();

    Person findById(long id);

    void deleteByName(String name);

    void deleteById(long id);

}
