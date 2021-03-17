package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "r_reference")
@Builder

public class Reference extends Element {
    @Column(name="r_reference")
    private String reference;

    @Column(name="r_type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_r_identifier", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @Column(name = "r_display")
    private String display;

}
