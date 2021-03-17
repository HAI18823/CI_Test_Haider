package at.spengergasse.spengermed.models;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "i_identifier")
@Builder
public class Identifier extends Element{

    public enum UseCode{
        usual, official, temp, secoundary, old;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="i_code")
    private UseCode code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="i_cc_id", referencedColumnName="id")
    private CodeableConcept type;

    @Column(name="i_system")
    private String system;

    @Column(name="i_value")
    private String value;

    @Embedded
    private Period period;
}
