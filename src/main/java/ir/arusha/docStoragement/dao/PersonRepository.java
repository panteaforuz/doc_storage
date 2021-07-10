package ir.arusha.docStoragement.dao;

import ir.arusha.docStoragement.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Long>{
    List<Person> findByNameContaining(String name);
}
