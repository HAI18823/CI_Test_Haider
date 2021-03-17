package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
//Todo: @Builder
@Table(name="pr_pradictioner")
@Builder
public class Pradictioner extends DomainResource{


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="i_pr_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    @Column(name="pr_active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hn_pr_id", referencedColumnName = "id")
    private List<HumanName> name = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_pradictioner_fk", referencedColumnName = "id")
    private List<ContactPoint> telecom = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_pr_id", referencedColumnName = "id")
    private List<Address> address = new ArrayList<>();

    //Aufzählung. Nur diese Werte können gespeichert werden
    public enum GenderCode{
        male, female, other, unknown
    }


    //EnumType.STRING bewirkt, dass die Textwerte von Enums in der DB gespeichert werden
    //Ansonsten würde die Position/Index gespeichert werde
    @Enumerated(EnumType.STRING)
    @Column(name= "pr_gender")
    private GenderCode gender;


    @Column(name="pr_birthdate")
    private LocalDate birthDate;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "at_pr_id", referencedColumnName = "id")
    private List<Attachment> photo = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "q_pr_id", referencedColumnName = "id")
    private List<Qualification> qualification = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_pr_id", referencedColumnName = "id")
    private List<CodeableConcept> communication = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "r_pr_id", referencedColumnName = "id")
    private List<Reference> generalPractiotioner = new ArrayList();

}
