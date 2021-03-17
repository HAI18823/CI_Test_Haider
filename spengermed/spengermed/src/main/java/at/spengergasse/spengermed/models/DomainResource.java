package at.spengergasse.spengermed.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class DomainResource  extends Resource{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="enc_subject_reference_fk", referencedColumnName = "id")
    private Narrative text;


}
