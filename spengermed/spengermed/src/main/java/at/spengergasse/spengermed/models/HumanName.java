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
@Table(name = "hn_humanname")
@Builder
public class HumanName extends Element{

    public enum UseCode{
        usual , official , temp , nickname , anonymous , old , maiden
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "hn_use")
    private UseCode use;

    @Column(name = "hn_text")
    private String text;

    @Column(name = "hn_family")
    private String family;


    @ElementCollection
    @CollectionTable(name = "g_given_hn", joinColumns = @JoinColumn(name = "id"))
    private List<String> given;

    @ElementCollection
    @CollectionTable(name = "gr_prefix_hn", joinColumns =
    @JoinColumn(name = "id"))
    private List<String> prefix;

    @ElementCollection
    @CollectionTable(name = "sus_surfix_hn", joinColumns =
    @JoinColumn(name = "id"))
    private List<String> surfix = new ArrayList<>();

    @Embedded
    private Period period;
}
