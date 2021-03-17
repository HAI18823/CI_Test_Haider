package at.spengergasse.spengermed.models;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.*;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "at_attachment")
@Builder
public class Attachment extends Element{
    public enum UseCode{
        charset, audio, email, text, image,other, unknown
    }
    @Enumerated(EnumType.STRING)
    @Column(name="at_contenttypecode")
    private UseCode contenttypecode;

    public enum Languageuse{
        ar("ar"),
        bn("bn"),
        cs("cs"),
        da("da"),
        de("de"),
        deat("de-AT"),
        dech("de-CH"),
        el("el"),
        en("en"),
        enau("en-AU"),
        enca ("en-CA"),
        engb("en-GB"),
        enin("en-IN"),
        ennz("en-NZ"),
        ensg("en-SG"),
        enus("en-US"),
        es("es"),
        esar("es-AR"),
        eses("es-Es"),
        esuy("es-UY"),
        fi("fi"),
        fr("fr"),
        frbe("fr-BE"),
        frch("fr-CH"),
        frfr("fr-FR"),
        fy("fy"),
        fynl("fy-NL"),
        hi("hi"),
        hr("hr"),
        it("it"),
        itch("it-CH"),
        itit("it-IT"),
        ja("ja"),
        ko("ko"),
        nl("nl"),
        nlbe("nl-BE"),
        nlnl("nl-NL"),
        no("no"),
        nono("no-NO"),
        pa("pa"),
        pl("pl"),
        pt("pt"),
        ptbr("pt-BR"),
        ru("ru"),
        ruru("ru-RU"),
        sr("sr"),
        srrs("sr-RS"),
        sv("sv"),
        svse("sv-SE"),
        te("te"),
        zh("zh"),
        zhch("zh-CH"),
        zhhk("zn-HK"),
        zhsg("zh-SG"),
        zhtw("zh-TW");
        private String value;

        private Languageuse(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }
    @Enumerated(EnumType.STRING)
    @Column(name="at_language")
    private Languageuse language;


    @Column(name="at_string")
    private String title;

    @Column(name="at_creation")
    private LocalDate creation;

    @Column(name="at_url")
    private String url;

    @Column(name="at_hash")
    private String hash;
    
    @Lob
    @Column(name="at_data")
    private byte[] data;


    @Column(name="at_size")
    private int size;

    void basicDecoder(final String encodedData) {
        byte[] decodeData = Base64.getDecoder().decode(encodedData);
        System.out.println(new String(decodeData, StandardCharsets.UTF_8));
    }
}
