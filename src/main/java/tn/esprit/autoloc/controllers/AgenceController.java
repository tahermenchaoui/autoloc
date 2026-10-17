package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.services.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@AllArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.consulterAgences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        Agence a = agenceService.consulterAgenceById(id);
        return a != null ? ResponseEntity.ok(a) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Agence create(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        Agence updated = agenceService.modifierAgence(agence);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenceService.supprimerAgenceById(id);
        return ResponseEntity.noContent().build();
    }
}
