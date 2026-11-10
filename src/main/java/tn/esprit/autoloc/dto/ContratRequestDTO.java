package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratRequestDTO(
        @NotNull(message = "La date de signature est obligatoire")
        LocalDate dateSignature,

        @NotNull(message = "Le montant total est obligatoire")
        @Positive(message = "Le montant total doit être positif")
        @Digits(integer = 8, fraction = 2, message = "Le montant doit avoir au plus 8 chiffres et 2 décimales")
        BigDecimal montantTotal,

        @NotNull(message = "L'indicateur de validité est obligatoire")
        Boolean valide,

        @Positive(message = "L'identifiant de la réservation doit être positif")
        Long idReservation
) {}