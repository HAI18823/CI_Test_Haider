package at.spengergasse.spengermed.models;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "q_qualification")
@Builder
public class Qualification extends BackboneElement {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_q_code", referencedColumnName = "id")
    private CodeableConcept code;

    @Embedded
    private Period period;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_q_identifier", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();
}
