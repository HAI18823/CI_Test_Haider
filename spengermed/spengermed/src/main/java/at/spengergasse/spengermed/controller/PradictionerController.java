package at.spengergasse.spengermed.controller;
import at.spengergasse.spengermed.models.Pradictioner;


import at.spengergasse.spengermed.repository.PradictionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.net.URI;
@RequestMapping(path = "/api/pradictioner")
@RestController
@CrossOrigin
public class PradictionerController {
    @Autowired
    private PradictionerRepository pradictionerRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Pradictioner> getAllPradictioners() {
// This returns a JSON or XML with the users
        return pradictionerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pradictioner> getPradictioners(@PathVariable String id) {
        return pradictionerRepository
                .findById(id)
                .map(pradictioner -> ResponseEntity.ok().body(pradictioner))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Pradictioner
    @PostMapping()
    public ResponseEntity<Pradictioner> createPradictioner( @RequestBody
                                                          Pradictioner pradictioner) {
        pradictioner.setId(null); // ensure to create new names
        var saved = pradictionerRepository.save(pradictioner);return ResponseEntity.created(URI.create("/api/pradictioner/" +
                saved.getId())).body(saved);
    }



    // Delete a Pradictioner
    @DeleteMapping("/{id}")
    public ResponseEntity<Pradictioner> deletePradictioner(@PathVariable(value =
            "id") String pradictionerId) {
        return pradictionerRepository
                .findById(pradictionerId)
                .map(
                        pradictioner -> {
                           pradictionerRepository.delete(pradictioner);
                            return ResponseEntity.ok().<Pradictioner>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Pradictioner
    @PutMapping("/{id}")
    public ResponseEntity<Pradictioner> updatePradictioner(
            @PathVariable(value = "id") String pradictionerId,
            @RequestBody Pradictioner pradictionerDetails) {
        return pradictionerRepository
                .findById(pradictionerId)
                .map(
                        pradictioner -> {

                            pradictioner.setActive(pradictionerDetails.isActive());
                            pradictioner.setGender(pradictionerDetails.getGender());
                            pradictioner.setIdentifier(pradictionerDetails.getIdentifier());
                            pradictioner.setName(pradictionerDetails.getName());
                            pradictioner.setAddress(pradictionerDetails.getAddress());
                            pradictioner.setBirthDate(pradictionerDetails.getBirthDate());
                            pradictioner.setTelecom(pradictionerDetails.getTelecom());

                            pradictioner.setPhoto(pradictionerDetails.getPhoto());
                            pradictioner.setQualification(pradictionerDetails.getQualification());
                            pradictioner.setCommunication(pradictionerDetails.getCommunication());



                            Pradictioner updatedPradictioner =
                                    pradictionerRepository.save(pradictioner);
                            return ResponseEntity.ok(updatedPradictioner);
                        }).orElseGet ( () -> createPradictioner(pradictionerDetails));
    }
}
