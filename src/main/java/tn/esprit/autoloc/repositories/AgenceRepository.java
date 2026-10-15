package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
