package at.spengergasse.spengermed.controller;
import at.spengergasse.spengermed.models.Procedure;

import at.spengergasse.spengermed.models.Procedure;
import at.spengergasse.spengermed.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.applet.Applet;
import java.net.URI;
@RequestMapping(path = "/api/procedure")
@RestController
@CrossOrigin
public class ProcedureController {
    @Autowired
    private ProcedureRepository procedureRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Procedure> getAllProcedurs() {
// This returns a JSON or XML with the users
        return procedureRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedure> getProcedure(@PathVariable String id) {
        return procedureRepository
                .findById(id)
                .map(procedure -> ResponseEntity.ok().body(procedure))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Procedure
    @PostMapping()
    public ResponseEntity<Procedure> createProcedure( @RequestBody
                                                               Procedure procedure) {
        procedure.setId(null);
        var saved = procedureRepository.save(procedure);
        return ResponseEntity.created(URI.create("/api/procedure/" +
                saved.getId())).body(saved);
    }



    // Delete a Procedure
    @DeleteMapping("/{id}")
    public ResponseEntity<Procedure> deleteProcedure(@PathVariable(value =
            "id") String procedureId) {
        return procedureRepository
                .findById(procedureId)
                .map(
                        procedure -> {
                            procedureRepository.delete(procedure);
                            return ResponseEntity.ok().<Procedure>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Procedure
    @PutMapping("/{id}")
    public ResponseEntity<Procedure> updateProcedure(
            @PathVariable(value = "id") String procedureId,
            @RequestBody Procedure procedureDeteils) {
        return procedureRepository
                .findById(procedureId)
                .map(
                        procedure -> {
                            procedure.setIdentifier(procedureDeteils.getIdentifier());
                            procedure.setPerformedDateTime(procedureDeteils.getPerformedDateTime());
                            procedure.setPerformedPeriod(procedureDeteils.getPerformedPeriod());
                            procedure.setInstantiatesUri(procedureDeteils.getInstantiatesUri());
                            procedure.setStatus(procedureDeteils.getStatus());

                            Procedure updatedProducer =
                                    procedureRepository.save(procedure);
                            return ResponseEntity.ok(updatedProducer);
                        }).orElseGet ( () -> createProcedure(procedureDeteils));
    }
}
