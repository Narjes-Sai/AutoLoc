package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import tn.esprit.autoloc.domain.ModePaiement;

public record PaiementRequestDTO(
        @NotNull(message = "Le montant est obligatoire")
        @Positive(message = "Le montant doit être positif")
        @Digits(integer = 8, fraction = 2, message = "Le montant doit avoir au plus 8 chiffres et 2 décimales")
        BigDecimal montant,

        @NotNull(message = "La date de paiement est obligatoire")
        @PastOrPresent(message = "La date de paiement ne peut pas être dans le futur")
        LocalDate datePaiement,

        @NotNull(message = "Le mode de paiement est obligatoire")
        ModePaiement modePaiement,

        @NotNull(message = "L'identifiant du contrat est obligatoire")
        @Positive(message = "L'identifiant du contrat doit être positif")
        Long idContrat
) {}