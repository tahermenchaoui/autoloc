package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
