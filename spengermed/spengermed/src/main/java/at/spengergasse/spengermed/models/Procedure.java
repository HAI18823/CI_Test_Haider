package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//manchmal muss das Programm einfach 2x gestartet werden

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
//Todo: @Builder
@Table(name="pro_procedure")
@Builder
public class Procedure extends DomainResource{


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="i_pro_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    @Column(name="pro_instantiatesuri")
    private String instantiatesUri;

    public enum StatusCode{
        preparation("preparation"),
        inprogress("in-progress"),
        notdone("not-done"),
        onhold("on-hold "),
        stopped("stopped "),
        completed("completed "),
        enteredinerror("entered-in-error"),
        unknown("unknown");


        private String value;

        private StatusCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

    }

    @Enumerated(EnumType.STRING)
    @Column(name="pro_status")
    private StatusCode status;

    @Column(name="pro_performeddatetime")
    private LocalDate performedDateTime;

    @Embedded
    private Period performedPeriod;


}
