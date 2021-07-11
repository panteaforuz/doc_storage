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
    public static enum Category {hr,software,hardware,it}
    Category category;
    private Date date;
    private String caption;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany(mappedBy = "documentSet", fetch = FetchType.LAZY)
    private Set<Person> persons = new HashSet<>();
}
