package at.spengergasse.spengermed.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Period {

    @Column(name="pp_start")
    private LocalDateTime start;

    @Column(name="pp_end")
    private LocalDateTime end;

}
