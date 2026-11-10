package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;

public record VehiculeRequestDTO(
        @NotBlank(message = "L'immatriculation est obligatoire")
        @Size(max = 20, message = "L'immatriculation ne doit pas dépasser 20 caractères")
        String immatriculation,

        @NotBlank(message = "La marque est obligatoire")
        String marque,

        @NotBlank(message = "Le modèle est obligatoire")
        String modele,

        @NotNull(message = "La catégorie est obligatoire")
        CategorieVehicule categorie,

        @NotNull(message = "Le tarif journalier est obligatoire")
        @PositiveOrZero(message = "Le tarif journalier ne peut pas être négatif")
        BigDecimal tarifJournalier,

        @NotNull(message = "Le statut est obligatoire")
        StatutVehicule statut
) {}