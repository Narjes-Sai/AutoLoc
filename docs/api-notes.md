# Atelier 5 - Notes : API REST, Postman et Swagger

## A. Endpoints

| Contrôleur | Verbe et route | Service appelé | Succès | Erreurs |
|---|---|---|---|---|
| ContratController | GET /api/contrats | findAll() | 200 | - |
| ContratController | GET /api/contrats/{id} | findById(id) | 200 | 404 |
| ContratController | POST /api/contrats | create(contrat) | 201 | 400 |
| ContratController | PUT /api/contrats/{id} | update(id, contrat) | 200 | 404, 400 |
| ContratController | DELETE /api/contrats/{id} | deleteById(id) | 204 | 404 |
| PaiementController | GET /api/paiements | findAll() | 200 | - |
| PaiementController | GET /api/paiements/{id} | findById(id) | 200 | 404 |
| PaiementController | POST /api/paiements | (aucun) | - | 405 |
| Agence, Employe, Vehicule, Equipement, Client, Reservation, Maintenance | GET/POST/PUT/DELETE sous /api/agences, /api/employes, /api/vehicules, /api/equipements, /api/clients, /api/reservations, /api/maintenances (5 endpoints chacun) | méthodes des services correspondants | 200 / 201 / 204 | 404, 400 |

## B. Annotations Jackson

| Association | Annotation | Justification |
|---|---|---|
| Contrat.paiements / Paiement.contrat | @JsonManagedReference / @JsonBackReference ("contrat-paiements") | Composition : les paiements sont créés dans le JSON du contrat |
| Agence.employes, Agence.vehicules, Client.reservations, Equipement.vehicules, Vehicule.maintenances, Vehicule.reservations, Reservation.contrat | @JsonIgnore | Côté inverse : évite la boucle ; l'enfant désigne son parent par identifiant |
| @ManyToOne LAZY (agence, client, vehicule, reservation) | @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) | Évite l'erreur de sérialisation des proxys Hibernate |

Différence : @JsonBackReference est lié à un @JsonManagedReference : le parent est omis à la sérialisation et le lien est reconstruit à la désérialisation. @JsonIgnore ignore simplement la propriété, sans reconstruction.

## C. Postman et Swagger

- Postman teste : requêtes rejouables avec assertions. Exemple : le 404 sur GET /api/contrats/9999 et la variable contratId réutilisée dans PUT et DELETE.
- Swagger UI documente et explore : contrat OpenAPI généré depuis le code. Exemple : groupes et réponses documentés (@Tag, @ApiResponse) à /api/swagger-ui.html.

## D. Anomalies SonarQube for IDE

| Règle | Explication | Correction |
|---|---|---|
| (à compléter) | (votre 1re anomalie réelle, ex. import inutile) | (à compléter) |
| (à compléter) | Entité JPA exposée directement par le contrôleur | Palliatif provisoire jusqu'aux DTO (Chapitre 10) |

## E. Questions de compréhension

1. Le DispatcherServlet reçoit toutes les requêtes. Il interroge le HandlerMapping, qui retrouve la méthode du contrôleur à partir du verbe HTTP et de l'URL.
2. Pour respecter les couches et garder un couplage faible : le contrôleur ne connaît ni la persistance ni l'implémentation, et le service reste remplaçable.
3. 201 = ressource créée, 204 = succès sans corps. Une ressource absente donne 404 car le GlobalExceptionHandler traduit ResourceNotFoundException ; sans lui, l'exception non gérée donnerait un 500.
4. Les paiements sont gérés par le Contrat (cascade). Un POST /api/paiements reçoit 405 Method Not Allowed.
5. Risques : couplage API/base, champs internes exposés, boucles de sérialisation, proxys LAZY. Contrat.paiements est une composition (les paiements naissent dans le JSON du contrat) : @JsonManagedReference. Agence.vehicules est le côté inverse d'une association où le véhicule désigne son agence par identifiant : @JsonIgnore.