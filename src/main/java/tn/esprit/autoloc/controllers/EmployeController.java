package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.services.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping
    public List<Employe> getAll() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable Long id) {
        Employe e = employeService.consulterEmployeById(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Employe create(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        Employe updated = employeService.modifierEmploye(employe);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeService.supprimerEmployeById(id);
        return ResponseEntity.noContent().build();
    }
}
