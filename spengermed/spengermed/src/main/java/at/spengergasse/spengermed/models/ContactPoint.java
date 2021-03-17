package at.spengergasse.spengermed.models;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cp_contactpoint")
@Builder
public class ContactPoint extends Element {
    public enum SystemCode {
        phone("phone"),
        fax("fax"),
        email("email"),
        pager("pager"),
        url("url"),
        sms("sms"),
        other("other");
        private String value;

        private SystemCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    public enum UseCode {
        home, work, temp, old, mobile
    }

    @Enumerated(EnumType.STRING)
    @Column(name="cp_system")
    private SystemCode system;
    @Column(name = "cp_value")
    private String value;
    @Enumerated(EnumType.STRING)
    @Column(name="cp_use")
    private UseCode use;
    @Column(name = "cp_rank")
    private int rank;
    @Embedded
    private Period period;
}