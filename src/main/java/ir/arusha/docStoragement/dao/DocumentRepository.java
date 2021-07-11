package ir.arusha.docStoragement.dao;

import ir.arusha.docStoragement.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document,Long> {

}
