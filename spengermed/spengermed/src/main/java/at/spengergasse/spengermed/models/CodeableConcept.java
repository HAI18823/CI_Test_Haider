package at.spengergasse.spengermed.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cc_codeableconcept")
@Builder
public class CodeableConcept extends Element{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_cc_id", referencedColumnName = "id")
    private List<Coding> coding;

    @Column(name="cc_text")
    private String text;
}
