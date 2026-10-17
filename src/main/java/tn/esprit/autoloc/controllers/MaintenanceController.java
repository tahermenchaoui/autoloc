package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.services.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.consulterMaintenances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getById(@PathVariable Long id) {
        Maintenance m = maintenanceService.consulterMaintenanceById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        Maintenance updated = maintenanceService.modifierMaintenance(maintenance);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        maintenanceService.supprimerMaintenanceById(id);
        return ResponseEntity.noContent().build();
    }
}
