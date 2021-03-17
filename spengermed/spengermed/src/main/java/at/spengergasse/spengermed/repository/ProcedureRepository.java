package at.spengergasse.spengermed.repository;

import at.spengergasse.spengermed.models.Patient;
import at.spengergasse.spengermed.models.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface ProcedureRepository extends  PagingAndSortingRepository<Procedure, String> {
}
