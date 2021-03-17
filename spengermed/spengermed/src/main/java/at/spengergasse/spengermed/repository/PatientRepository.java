package at.spengergasse.spengermed.repository;

import at.spengergasse.spengermed.models.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface PatientRepository extends
        PagingAndSortingRepository<Patient, String> {
}