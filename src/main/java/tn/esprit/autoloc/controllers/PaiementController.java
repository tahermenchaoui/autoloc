package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.services.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@AllArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.consulterPaiements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getById(@PathVariable Long id) {
        Paiement p = paiementService.consulterPaiementById(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        Paiement updated = paiementService.modifierPaiement(paiement);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paiementService.supprimerPaiementById(id);
        return ResponseEntity.noContent().build();
    }
}
