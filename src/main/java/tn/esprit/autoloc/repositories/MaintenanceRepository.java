package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
