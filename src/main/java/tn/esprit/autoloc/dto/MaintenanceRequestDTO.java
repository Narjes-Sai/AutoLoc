package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record MaintenanceRequestDTO(
        @NotNull(message = "La date de début est obligatoire")
        LocalDate dateDebut,

        LocalDate dateFin,

        @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères")
        String description,

        @NotNull(message = "L'identifiant du véhicule est obligatoire")
        @Positive(message = "L'identifiant du véhicule doit être positif")
        Long idVehicule
) {}