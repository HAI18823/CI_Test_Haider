package at.spengergasse.spengermed.repository;

import at.spengergasse.spengermed.models.Pradictioner;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface PradictionerRepository extends
        PagingAndSortingRepository<Pradictioner, String> {
}
