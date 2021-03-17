package at.spengergasse.spengermed;

import at.spengergasse.spengermed.models.*;
import at.spengergasse.spengermed.repository.PatientRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Durch diese Annotation wird aus der Klasse eine Testklasse
@SpringBootTest
public class PatientRepositoryTest {
    @Autowired
    PatientRepository patientRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOnePatient() {
            //1. Erstellen einer mit Daten befüllten Patienteninstanz
            Patient p = returnOnePatient();
            //2. Instanz in die DB speichern
            Patient savedP = patientRepository.save(p);
            //3. Gespeicherte Daten aus der DB lesen
            Patient loadedPatient = patientRepository.findById(savedP.getId()).get();
            System.out.println(loadedPatient);

            //4. Vergleich des gespeicherten Objekts mit dem geladenen
            //Attribute, die keine Listen sind
            assertEquals(p.getBirthDate(),savedP.getBirthDate());
            assertEquals(p.getDeceasedDateTime(),savedP.getDeceasedDateTime());
            assertEquals(p.getGender(),savedP.getGender());
            assertEquals(p.getText(),savedP.getText());


            //Es sollen alle Attribute verglichen werden, auch die geerbten.
            //Collections werden mit CollectionUtils auf gleichheit getestet.
            //Dabei werden die einzelnen Elemente verglichen,nicht ob die
            //Collectionobjekte gleich sind.
            assertTrue(CollectionUtils.isEqualCollection(p.getIdentifier(), loadedPatient.getIdentifier()));
            assertTrue(CollectionUtils.isEqualCollection(p.getName(), loadedPatient.getName()));
            assertTrue(CollectionUtils.isEqualCollection(p.getTelecom(), loadedPatient.getTelecom()));
            assertTrue(CollectionUtils.isEqualCollection(p.getAddress(), loadedPatient.getAddress()));
            //Es sollen alle Collections getestet werden.
        }

        //Ein Patientenobjekt. Alle Attribute sollen Werte bekommen.
        //Auch die Collections sollen zumindest 1 Wert haben.
       //Liefert eine Instanz von einem Patienten
        public static Patient returnOnePatient() {
            List<Identifier> identifiers = new ArrayList<>();
            List<Coding> codings = new ArrayList<>();
            List<ContactPoint> contactPoints = new ArrayList<>();
            List<HumanName> names = new ArrayList<>();List<Address> address = new ArrayList<>();
            List<String> prefixes = null;
            List<String> suffixes = null;


            //Ein Coding Objekt wird mit wie bisher mit einem Konstruktorgebaut.
            codings.add(new Coding("System","0.1.1","Code","<div> ...<div>",false));

            //Eine Period mit Kontsturktor
            Period period = new Period(LocalDateTime.of(2000, 01, 01, 1, 1), LocalDateTime.of(2001, 01, 01, 1, 1));

            //Eine Period mit dem Builder Pattern. Es ist offensichtlicher,
            //welche Attribute gesetzt werden.


            Period period2= Period.builder()
                    .start(LocalDateTime.of(2020,01,01,1,1))
                    .end(LocalDateTime.of(2021,02,02,2,2))
                    .build();

            Period period3 = Period.builder()
                    .start(LocalDateTime.of(2001, 01, 01, 1, 1))
                    .end(LocalDateTime.of(2011, 02, 02, 2, 2))
                    .build();// new CodeableConcept(codings, "Text");

            CodeableConcept ccType = CodeableConcept.builder()
                    .coding(codings)
                    .text("<div></div>")
                    .build();


            identifiers.add(
                    Identifier.builder()
                            .code(Identifier.UseCode.official)
                            .period(period)
                            .system("System")
                            .type(ccType)
                            .value("value")
                            .build()
            );
            contactPoints.add(
                    ContactPoint.builder()
                            .period(period2)
                            .rank(1)
                            .system(ContactPoint.SystemCode.email)
                            .use(ContactPoint.UseCode.home)
                            .value("pirker@spengergasse.at")
                            .build()//new ContactPoint(ContactPoint.SystemCode.phone, "123454321", ContactPoint.UseCode.home, 1, period2)

            );

            List<String> givennames= new ArrayList<>();
            givennames.add("Simon");
            givennames.add("2. Vorname");

            names.add(HumanName.builder()
                    .family("Pirker")
                    .given(givennames)
                    .period(Period.builder().start(LocalDateTime.now()).end(LocalDateTime.now()).build())
                    .use(HumanName.UseCode.anonymous)
                    .build());


            address.add(
                    Address.builder()
                            .city("Wien")
                            .country("Österreich")
                            .district("Wien")
                            .line("Spengergasse 20")
                            .postalcode("1050")
                            .period(period3)
                            .state("Wien")
                            .text("<div>.../</div>")
                            .type(Address.TypeCode.both)
                            .use(Address.UseCode.home)
                            .build()
            );



            return Patient.builder()
                    .active(true)
                    .birthDate(LocalDate.of(1999, 01, 01))
                    .identifier(identifiers)
                    .deceasedBoolean(false)
                    .gender(Patient.GenderCode.male)
                    .name(names)
                    .telecom(contactPoints)
                    .address(address)
                    .build();

    }
}

