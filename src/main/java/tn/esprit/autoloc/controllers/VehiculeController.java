package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.services.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@AllArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.consulterVehicules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        Vehicule v = vehiculeService.consulterVehiculeById(id);
        return v != null ? ResponseEntity.ok(v) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        Vehicule updated = vehiculeService.modifierVehicule(vehicule);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculeService.supprimerVehiculeById(id);
        return ResponseEntity.noContent().build();
    }
}
