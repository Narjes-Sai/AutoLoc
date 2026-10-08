# Notes Atelier 3 : couche Repository

## Choix d'interface

| Interface | Étend | Justification |
|---|---|---|
| IContratRepository | JpaRepository<Contrat, Long> | CRUD complet, findAll renvoie une List, saveAndFlush disponible. |
| IAgenceRepository | JpaRepository<Agence, Long> | CRUD, listes, tri et pagination. |
| IEmployeRepository | JpaRepository<Employe, Long> | CRUD, listes, tri et pagination. |
| IVehiculeRepository | JpaRepository<Vehicule, Long> | CRUD, listes, tri et pagination. |
| IEquipementRepository | JpaRepository<Equipement, Long> | CRUD, listes, tri et pagination. |
| IClientRepository | JpaRepository<Client, Long> | CRUD, listes, tri et pagination. |
| IReservationRepository | JpaRepository<Reservation, Long> | CRUD, listes, tri et pagination. |
| IPaiementRepository | JpaRepository<Paiement, Long> | Lecture des paiements ; création et suppression via le Contrat (composition). |
| IMaintenanceRepository | JpaRepository<Maintenance, Long> | CRUD, listes, tri et pagination. |

## Anomalies SonarQube for IDE

| Anomalie | Règle / explication | Correction apportée |
|---|---|---|
| Import inutilisé | java:S1128, import jamais utilisé | Import supprimé |
| Classe de démonstration | Code inutile après observation | DemoContratRunner supprimée |
| Import avec joker `jakarta.persistence.*` | Lisibilité, dépendances cachées | Imports explicites |

(Remplacez par les anomalies réellement détectées chez vous.)

## Points à retenir

- `save()` : id null, persist (INSERT) ; id renseigné, merge (SELECT puis UPDATE).
- `deleteById()` passe par le contexte de persistance : cascade et orphanRemoval s'appliquent.
- `deleteAllInBatch()` contourne cascade et orphanRemoval : risque de paiements orphelins ou d'erreur de clé étrangère.
- `CrudRepository.findAll()` renvoie un `Iterable` ; `JpaRepository.findAll()` renvoie une `List`.