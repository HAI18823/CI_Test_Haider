package at.spengergasse.spengermed.models;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "r_resource")
public abstract class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    @Column(name="id")
    private String id;
}
