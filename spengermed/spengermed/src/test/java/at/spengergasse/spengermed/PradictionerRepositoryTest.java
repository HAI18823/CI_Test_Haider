package at.spengergasse.spengermed;

import at.spengergasse.spengermed.models.*;
import at.spengergasse.spengermed.repository.PradictionerRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PradictionerRepositoryTest {
    @Autowired
    PradictionerRepository pradictionerRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOnePradictioner() {
        //1. Erstellen einer mit Daten befüllten Patienteninstanz
        Pradictioner pr = returnOnePradictioner();
        //2. Instanz in die DB speichern
        Pradictioner savedPr = pradictionerRepository.save(pr);
        //3. Gespeicherte Daten aus der DB lesen
        Pradictioner loadedPradictioner = pradictionerRepository.findById(savedPr.getId()).get();
        System.out.println(loadedPradictioner);

        //4. Vergleich des gespeicherten Objekts mit dem geladenen
        //Attribute, die keine Listen sind
        assertEquals(pr.getBirthDate(), savedPr.getBirthDate());
        assertEquals(pr.getText(), savedPr.getText());
        assertEquals(pr.isActive(), savedPr.isActive());
        assertEquals(pr.getGender(), savedPr.getGender());


        //Es sollen alle Attribute verglichen werden, auch die geerbten.
        //Collections werden mit CollectionUtils auf gleichheit getestet.
        //Dabei werden die einzelnen Elemente verglichen,nicht ob die
        //Collectionobjekte gleich sind.
        assertTrue(CollectionUtils.isEqualCollection(pr.getIdentifier(), loadedPradictioner.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(pr.getName(), loadedPradictioner.getName()));
        assertTrue(CollectionUtils.isEqualCollection(pr.getTelecom(), loadedPradictioner.getTelecom()));
        assertTrue(CollectionUtils.isEqualCollection(pr.getAddress(), loadedPradictioner.getAddress()));
        assertTrue(CollectionUtils.isEqualCollection(pr.getQualification(), loadedPradictioner.getQualification()));
        assertTrue(CollectionUtils.isEqualCollection(pr.getCommunication(), loadedPradictioner.getCommunication()));
        assertTrue(CollectionUtils.isEqualCollection(pr.getPhoto(), loadedPradictioner.getPhoto()));
        //Es sollen alle Collections getestet werden.

    }

    @Test
    @Transactional
    public void testUpdateOnePractitioner() {
        Pradictioner p = returnOnePradictioner();
        Pradictioner pradictionertochange = pradictionerRepository.findById("lol").get();

        pradictionertochange.setGender(p.getGender());
        pradictionertochange.setBirthDate(p.getBirthDate());
        pradictionertochange.setActive(p.isActive());
        pradictionertochange.setTelecom(p.getTelecom());
        pradictionertochange.setPhoto(p.getPhoto());
        pradictionertochange.setName(p.getName());
        pradictionertochange.setAddress(p.getAddress());
        pradictionertochange.setCommunication(p.getCommunication());
        pradictionertochange.setQualification(p.getQualification());
        pradictionertochange.setText(p.getText());
        pradictionertochange.setIdentifier(p.getIdentifier());
        Pradictioner savedP = pradictionerRepository.save(pradictionertochange);

        Pradictioner loadedPradictioner = pradictionerRepository.findById(savedP.getId()).get();
        System.out.println(loadedPradictioner);


        Pradictioner updatedP = pradictionerRepository.save(savedP);
        Pradictioner newUpdatedP = pradictionerRepository.findById(updatedP.getId()).get();


        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getIdentifier(), loadedPradictioner.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getName(), loadedPradictioner.getName()));
        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getTelecom(), loadedPradictioner.getTelecom()));
        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getAddress(), loadedPradictioner.getAddress()));
        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getQualification(), loadedPradictioner.getQualification()));
        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getCommunication(), loadedPradictioner.getCommunication()));
        assertTrue(CollectionUtils.isEqualCollection(pradictionertochange.getPhoto(), loadedPradictioner.getPhoto()));

        assertEquals(pradictionertochange.getBirthDate(), savedP.getBirthDate());
        assertEquals(pradictionertochange.getText(), savedP.getText());
        assertEquals(pradictionertochange.isActive(), savedP.isActive());
        assertEquals(pradictionertochange.getGender(), savedP.getGender());


    }

    @Test
    @Transactional
    public void testDeleteOnePradictioner() {

        Pradictioner pr = returnOnePradictioner();

        Pradictioner savedpr =pradictionerRepository.save(pr);

        pradictionerRepository.deleteById(savedpr.getId());

        boolean exists = pradictionerRepository.existsById(savedpr.getId());


        assertFalse(exists);
    }

    static Pradictioner returnOnePradictioner() {
        List<Identifier> identifiers = new ArrayList<>();
        List<Coding> codings = new ArrayList<>();
        List<ContactPoint> contactPoints = new ArrayList<>();
        List<HumanName> names = new ArrayList<>();
        List<Address> address = new ArrayList<>();
        List<String> prefixes = null;
        List<String> suffixes = null;
        List<Qualification> qualifications = new ArrayList<>();
        List<CodeableConcept> communicatione = new ArrayList<>();
        List<Attachment> photos = new ArrayList<>();

        //Ein Coding Objekt wird mit wie bisher mit einem Konstruktorgebaut.
        codings.add(new Coding("System", "0.1.1", "Code", "<div> ...<div>", false));

        //Eine Period mit Kontsturktor
        Period period = new Period(LocalDateTime.of(2000, 01, 01, 1, 1), LocalDateTime.of(2001, 01, 01, 1, 1));

        //Eine Period mit dem Builder Pattern. Es ist offensichtlicher,
        //welche Attribute gesetzt werden.


        Period period2 = Period.builder()
                .start(LocalDateTime.of(2020, 01, 01, 1, 1))
                .end(LocalDateTime.of(2021, 02, 02, 2, 2))
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

        List<String> givennames = new ArrayList<>();
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

        qualifications.add(Qualification.builder()
                .code(ccType)
                .identifier(identifiers)
                .period(period3)
                .build());

        communicatione.add(CodeableConcept.builder()
                        .coding(codings)
                        .text("lol")
                        .build()
        );

        photos.add(Attachment.builder()
                .contenttypecode(Attachment.UseCode.email)
                .language(Attachment.Languageuse.ar)
                .title("Hallo")
                .creation(LocalDate.of(2021, 02,24))
                .data("Schule")
                .hash("---")
                .size(12)
                .url("https: --- .com ")
                .build());

        return Pradictioner.builder()
                .active(true)
                .birthDate(LocalDate.of(1999, 01, 01))
                .identifier(identifiers)
                .name(names)
                .telecom(contactPoints)
                .address(address)
                .qualification(qualifications)
                .communication(communicatione)
                .photo(photos)
                .build();


    }

}
