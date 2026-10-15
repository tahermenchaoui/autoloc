package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
