package tn.esprit.autoloc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ContratResponseDTO(
        Long idContrat,
        LocalDate dateSignature,
        BigDecimal montantTotal,
        boolean valide,
        Long idReservation,
        List<PaiementResponseDTO> paiements
) {}