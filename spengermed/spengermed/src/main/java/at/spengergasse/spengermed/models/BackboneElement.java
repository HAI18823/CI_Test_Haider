package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.security.cert.Extension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@Table(name="be_backboneelement")
public class BackboneElement extends Element{


}
