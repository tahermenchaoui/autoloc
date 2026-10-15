package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
