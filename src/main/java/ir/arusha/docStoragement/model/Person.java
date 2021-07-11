package ir.arusha.docStoragement.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = "id")  /////
@ToString
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name ="students")
public class Person {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "persons_documents",
//            joinColumns = {
//                    @JoinColumn(name = "persons_id", referencedColumnName = "id",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "documents_id", referencedColumnName = "id",
//                            nullable = false, updatable = false)})
    private Set <Document> documentSet = new HashSet<>();
}
