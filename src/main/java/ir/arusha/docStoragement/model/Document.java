package ir.arusha.docStoragement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = "id")  /////
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "documents")
public class Document {
    Category category;
    private Date date;
    private String caption;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Person> persons = new HashSet<>();
    public enum Category {hr, software, hardware, it}
}
