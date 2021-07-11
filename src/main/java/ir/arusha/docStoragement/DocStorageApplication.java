package ir.arusha.docStoragement;

import ir.arusha.docStoragement.dao.DocumentRepository;
import ir.arusha.docStoragement.dao.PersonRepository;
import ir.arusha.docStoragement.model.Document;
import ir.arusha.docStoragement.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.print.attribute.DateTimeSyntax;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DocStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocStorageApplication.class, args);
	}

	@Bean
	public CommandLineRunner mapping(PersonRepository personRepository,
										 DocumentRepository documentRepository) {
		return args -> {
			//create persons
			Person p1 = Person.builder().name("panteA foruz").build();
			Person p2 = Person.builder().name("sara karimi").build();
			Person p3 = Person.builder().name("ali zare").build();
			// save the persons
			personRepository.saveAll(Arrays.asList(p1,p2,p3));
			// create docs
			Document doc1 = Document.builder().category(Document.Category.hr).caption("this is caption of doc1").date(new Date()).build();
			Document doc2 = Document.builder().category(Document.Category.hardware).caption("this is caption of doc1").date(new Date()).build();
			Document doc3 = Document.builder().category(Document.Category.software).caption("this is caption of doc1").date(new Date()).build();
			Document doc4 = Document.builder().category(Document.Category.it).caption("this is caption of doc1").date(new Date()).build();
			// save docs
			documentRepository.saveAll(Arrays.asList(doc1, doc2, doc3,doc4));
			// add docs to the persons
			p1.getDocumentSet().addAll(Arrays.asList(doc1,doc2));
			p2.getDocumentSet().add(doc3);
			p2.getDocumentSet().addAll(Arrays.asList(doc4,doc3));
			//updating persons
			personRepository.save(p1);
			personRepository.save(p2);
			personRepository.save(p3);
		};
	}
}