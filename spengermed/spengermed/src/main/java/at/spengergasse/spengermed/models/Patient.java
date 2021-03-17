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
@Builder
@Table(name="p_patient")
public class Patient extends DomainResource{

    //Aufzählung. Nur diese Werte können gespeichert werden
    public enum GenderCode{
        male, female, other, unknown
    }

    //EnumType.STRING bewirkt, dass die Textwerte von Enums in der DB gespeichert werden
    //Ansonsten würde die Position/Index gespeichert werde
    @Enumerated(EnumType.STRING)
    @Column(name= "p_gender")
    private GenderCode gender;

    @Column(name="p_deceaseddatetime")
    private LocalDate deceasedDateTime;

    //1:n oder 0..* zu einem Identifier Element
    // CascadeType.ALL -wenn der Patient gelöscht wird, werden auch alle Identifier dazu gelöscht
    @OneToMany(cascade = CascadeType.ALL)
    //Der ForeignKey ist i_patient_fk in der Tabelle Identifier. Immer auf der "n" Seite.
    //Dieser ForeignKey referenziert auf den PrimaryKey von Patient, der heißt "id"
    @JoinColumn(name ="i_p_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    @Column(name="p_active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hn_p_id", referencedColumnName = "id")
    private List<HumanName> name = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_patient_fk", referencedColumnName = "id")
    private List<ContactPoint> telecom = new ArrayList<>();

    //Bei Datum und Zeit immer Local verwenden
    @Column(name="p_birthdate")
    private LocalDate birthDate;

    //Alternative ? Felder-es wird in der DB beides abgebildet,
    // Im Controller nur 1 erlaubt.
    @Column(name="p_deceasedboolean")
    private boolean deceasedBoolean;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_p_id", referencedColumnName = "id")
    private List<Address> address = new ArrayList<>();

   }
