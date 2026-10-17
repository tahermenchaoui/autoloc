# AutoLoc — Spécifications des requêtes POSTMAN (CRUD toutes entités)

Base URL : `http://localhost:8080/api`
Méthodes : GET, POST, PUT, DELETE
Content-Type : `application/json`

---

## 1. Véhicules — /api/vehicules

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/vehicules | — |
| Lire par id | GET | /api/vehicules/1 | — |
| Créer | POST | /api/vehicules | `{ "immatriculation": "AB-123-CD", "marque": "Peugeot", "modele": "208", "categorie": "CITADINE", "tarifJournalier": 45.00, "statut": "DISPONIBLE", "agence": { "idAgence": 1 }, "equipements": [], "reservations": [], "maintenances": [] }` |
| Modifier | PUT | /api/vehicules/1 | Même JSON avec idVehicule:1 |
| Supprimer | DELETE | /api/vehicules/1 | — |

---

## 2. Réservations — /api/reservations

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/reservations | — |
| Lire par id | GET | /api/reservations/1 | — |
| Créer | POST | /api/reservations | `{ "dateDebut": "2026-11-01", "dateFin": "2026-11-05", "statut": "EN_ATTENTE", "client": { "idClient": 1 }, "vehicule": { "idVehicule": 1 }, "contrat": null }` |
| Modifier | PUT | /api/reservations/1 | Même JSON avec idReservation:1 |
| Supprimer | DELETE | /api/reservations/1 | — |

---

## 3. Paiements — /api/paiements

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/paiements | — |
| Lire par id | GET | /api/paiements/1 | — |
| Créer | POST | /api/paiements | `{ "montant": 225.00, "datePaiement": "2026-11-01", "modePaiement": "CARTE_BANCAIRE", "contrat": { "idContrat": 1 } }` |
| Modifier | PUT | /api/paiements/1 | Même JSON avec idPaiement:1 |
| Supprimer | DELETE | /api/paiements/1 | — |

---

## 4. Maintenance — /api/maintenances

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/maintenances | — |
| Lire par id | GET | /api/maintenances/1 | — |
| Créer | POST | /api/maintenances | `{ "dateDebut": "2026-10-01", "dateFin": "2026-10-02", "description": "Vidange", "vehicule": { "idVehicule": 1 } }` |
| Modifier | PUT | /api/maintenances/1 | Même JSON avec idMaintenance:1 |
| Supprimer | DELETE | /api/maintenances/1 | — |

---

## 5. Équipements — /api/equipements

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/equipements | — |
| Lire par id | GET | /api/equipements/1 | — |
| Créer | POST | /api/equipements | `{ "libelle": "GPS", "vehicules": [] }` |
| Modifier | PUT | /api/equipements/1 | Même JSON avec idEquipement:1 |
| Supprimer | DELETE | /api/equipements/1 | — |

---

## 6. Clients — /api/clients

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/clients | — |
| Lire par id | GET | /api/clients/1 | — |
| Créer | POST | /api/clients | `{ "nom": "Dupont", "prenom": "Jean", "email": "jean@mail.com", "telephone": "0600000000", "numPermis": "PERM123", "dateInscription": "2026-01-10", "reservations": [] }` |
| Modifier | PUT | /api/clients/1 | Même JSON avec idClient:1 |
| Supprimer | DELETE | /api/clients/1 | — |

---

## 7. Agences — /api/agences

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/agences | — |
| Lire par id | GET | /api/agences/1 | — |
| Créer | POST | /api/agences | `{ "nom": "Agence Centre", "ville": "Tunis", "adresse": "Rue X", "telephone": "71000000", "vehicules": [], "employes": [] }` |
| Modifier | PUT | /api/agences/1 | Même JSON avec idAgence:1 |
| Supprimer | DELETE | /api/agences/1 | — |

---

## 8. Contrats — /api/contrats

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/contrats | — |
| Lire par id | GET | /api/contrats/1 | — |
| Créer | POST | /api/contrats | `{ "dateSignature": "2026-11-01", "montantTotal": 225.00, "valide": true, "reservation": { "idReservation": 1 }, "paiements": [] }` |
| Modifier | PUT | /api/contrats/1 | Même JSON avec idContrat:1 |
| Supprimer | DELETE | /api/contrats/1 | — |

---

## 9. Employés — /api/employes

| Opération | Méthode | URL | Body (JSON) |
|-----------|---------|-----|-------------|
| Lister tous | GET | /api/employes | — |
| Lire par id | GET | /api/employes/1 | — |
| Créer | POST | /api/employes | `{ "nom": "Ben Ali", "prenom": "Sara", "role": "GERANT", "agence": { "idAgence": 1 } }` |
| Modifier | PUT | /api/employes/1 | Même JSON avec idEmploye:1 |
| Supprimer | DELETE | /api/employes/1 | — |

---

### Enums autorisés (chaîne)
- `CategorieVehicule` : CITADINE, BERLINE, SUV, UTILITAIRE
- `StatutVehicule` : DISPONIBLE, LOUE, EN_MAINTENANCE
- `StatutReservation` : EN_ATTENTE, CONFIRMEE, ANNULEE, TERMINEE
- `ModePaiement` : ESPECE, CARTE_BANCAIRE, CHEQUE, VIREMENT
- `RoleEmploye` : GERANT, EMPLOYE

### Prérequis MySQL
Base `autoloc_db` sur `localhost:3306`, user `root` sans mot de passe (application.properties). `spring.jpa.hibernate.ddl-auto=update` crée les tables automatiquement.
