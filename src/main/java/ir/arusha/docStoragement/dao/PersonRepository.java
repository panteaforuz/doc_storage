package ir.arusha.docStoragement.dao;

import ir.arusha.docStoragement.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{
    List<Person> findByNameContaining(String name);
}
