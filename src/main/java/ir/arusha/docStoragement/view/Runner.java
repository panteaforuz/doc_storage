package ir.arusha.docStoragement.view;

import ir.arusha.docStoragement.dao.DocumentRepository;
import ir.arusha.docStoragement.dao.PersonRepository;
import ir.arusha.docStoragement.model.Document;
import ir.arusha.docStoragement.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class Runner {
    public Runner(DocumentRepository documentRepository, PersonRepository personRepository) {
        System.out.println("persons would be create in next lines");
        //create persons
        Person p1 = Person.builder().name("panteA foruz").build();
        Person p2 = Person.builder().name("sara karimi").build();
        Person p3 = Person.builder().name("ali zare").build();
        // save the persons
        personRepository.saveAll(Arrays.asList(p1, p2, p3));
        log.info("The built persons were saved");
        // create docs
        Document doc1 = Document.builder().category(Document.Category.hr).caption("this is caption of doc1").date(new Date()).build();
        Document doc2 = Document.builder().category(Document.Category.hardware).caption("this is caption of doc1").date(new Date()).build();
        Document doc3 = Document.builder().category(Document.Category.software).caption("this is caption of doc1").date(new Date()).build();
        Document doc4 = Document.builder().category(Document.Category.it).caption("this is caption of doc1").date(new Date()).build();
        // save docs
        documentRepository.saveAll(Arrays.asList(doc1, doc2, doc3, doc4));
        log.info("The built docs were saved");
        List<Person> personList = personRepository.findByNameContaining("panteA");
        ///read and update persons
        if (!personList.isEmpty()) {
            for (Person person : personList) {
                person.getDocumentSet().add(doc1);
                System.out.println(person);
            }
        }
        personRepository.deleteById(1L);
        log.warn("person with id = 1 deleted");
    }

}
