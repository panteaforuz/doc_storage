package ir.arusha.docStoragement.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "documents")
public class Document {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToMany(mappedBy = "documents", fetch = FetchType.LAZY)
    private Set<Person> persons = new HashSet<>();
}
