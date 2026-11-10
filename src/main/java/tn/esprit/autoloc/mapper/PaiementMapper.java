package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.dto.PaiementRequestDTO;
import tn.esprit.autoloc.dto.PaiementResponseDTO;

@Component
public class PaiementMapper {

    public Paiement toEntity(PaiementRequestDTO dto) {
        Paiement p = new Paiement();
        updateEntity(p, dto);
        return p;
    }

    public void updateEntity(Paiement p, PaiementRequestDTO dto) {
        p.setMontant(dto.montant());
        p.setDatePaiement(dto.datePaiement());
        p.setModePaiement(dto.modePaiement());
    }

    public PaiementResponseDTO toResponse(Paiement p) {
        return new PaiementResponseDTO(p.getIdPaiement(), p.getMontant(), p.getDatePaiement(),
                p.getModePaiement(), p.getContrat().getIdContrat());
    }
}