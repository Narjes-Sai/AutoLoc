package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import tn.esprit.autoloc.domain.StatutReservation;

public record ReservationRequestDTO(
        @NotNull(message = "La date de début est obligatoire")
        LocalDate dateDebut,

        @NotNull(message = "La date de fin est obligatoire")
        LocalDate dateFin,

        @NotNull(message = "Le statut est obligatoire")
        StatutReservation statut,

        @NotNull(message = "L'identifiant du client est obligatoire")
        @Positive(message = "L'identifiant du client doit être positif")
        Long idClient,

        @NotNull(message = "L'identifiant du véhicule est obligatoire")
        @Positive(message = "L'identifiant du véhicule doit être positif")
        Long idVehicule
) {}