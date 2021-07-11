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
	public CommandLineRunner mappingDemo(PersonRepository personRepository,
										 DocumentRepository documentRepository) {
		return args -> {
			//create persons
			Person p1 = Person.builder().name("panteA foruz").build();
			Person p2 = Person.builder().name("sara karimi").build();
			Person p3 = Person.builder().name("ali zare").build();
			// save the persons
			personRepository.saveAll(Arrays.asList(p1,p2,p3));
			// create docs
			Document doc1 = Document.builder().category(Document.Category.hr).file(new File("test1File.txt")).date(new Date()).build();
			Document doc2 = Document.builder().category(Document.Category.hardware).file(new File("test2File.txt")).date(new Date()).build();
			Document doc3 = Document.builder().category(Document.Category.software).file(new File("test3File.txt")).date(new Date()).build();
			Document doc4 = Document.builder().category(Document.Category.it).file(new File("test4File.txt")).date(new Date()).build();
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