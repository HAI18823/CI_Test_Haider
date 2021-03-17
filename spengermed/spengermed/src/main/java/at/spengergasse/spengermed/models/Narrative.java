package at.spengergasse.spengermed.models;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name= "n_narrative")
@Builder
public class Narrative extends Element{
    public enum NarrativeCode{
        generated, extensions, aditional, empty
    }

    @Column(name="n_status")
    private NarrativeCode status;

    @Column(name="n_div")
    private String div;
}
