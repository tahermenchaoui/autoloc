package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.services.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@AllArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @GetMapping
    public List<Equipement> getAll() {
        return equipementService.consulterEquipements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getById(@PathVariable Long id) {
        Equipement e = equipementService.consulterEquipementById(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> update(@PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        Equipement updated = equipementService.modifierEquipement(equipement);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipementService.supprimerEquipementById(id);
        return ResponseEntity.noContent().build();
    }
}
