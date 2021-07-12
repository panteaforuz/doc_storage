package ir.arusha.docStoragement.view;

import ir.arusha.docStoragement.dao.DocumentRepository;
import ir.arusha.docStoragement.dao.PersonRepository;
import ir.arusha.docStoragement.model.Document;
import ir.arusha.docStoragement.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
@Component
@RequiredArgsConstructor
public class Runner {
    // @Autowired
    private final PersonRepository personRepository;
    private final DocumentRepository documentRepository;

    @PostConstruct
    private void run() {
        System.out.println("hiii");
        //create persons
        Person p1 = Person.builder().name("panteA foruz").build();
        Person p2 = Person.builder().name("sara karimi").build();
        Person p3 = Person.builder().name("ali zare").build();
        // save the persons
        personRepository.saveAll(Arrays.asList(p1, p2, p3));
        // create docs
        Document doc1 = Document.builder().category(Document.Category.hr).caption("this is caption of doc1").date(new Date()).build();
        Document doc2 = Document.builder().category(Document.Category.hardware).caption("this is caption of doc1").date(new Date()).build();
        Document doc3 = Document.builder().category(Document.Category.software).caption("this is caption of doc1").date(new Date()).build();
        Document doc4 = Document.builder().category(Document.Category.it).caption("this is caption of doc1").date(new Date()).build();
        // save docs
        documentRepository.saveAll(Arrays.asList(doc1, doc2, doc3, doc4));
        // add docs to the persons
        p1.getDocumentSet().addAll(Arrays.asList(doc1, doc2));
        p2.getDocumentSet().add(doc3);
        p2.getDocumentSet().addAll(Arrays.asList(doc4, doc3));
        //updating persons
        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
    }
}
