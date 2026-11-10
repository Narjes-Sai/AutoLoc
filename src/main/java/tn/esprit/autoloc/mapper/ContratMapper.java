package tn.esprit.autoloc.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.dto.ContratRequestDTO;
import tn.esprit.autoloc.dto.ContratResponseDTO;

@Component
@RequiredArgsConstructor
public class ContratMapper {

    private final PaiementMapper paiementMapper;

    public Contrat toEntity(ContratRequestDTO dto) {
        Contrat c = new Contrat();
        updateEntity(c, dto);
        return c;
    }

    public void updateEntity(Contrat c, ContratRequestDTO dto) {
        c.setDateSignature(dto.dateSignature());
        c.setMontantTotal(dto.montantTotal());
        c.setValide(dto.valide());
    }

    public ContratResponseDTO toResponse(Contrat c) {
        return new ContratResponseDTO(
                c.getIdContrat(),
                c.getDateSignature(),
                c.getMontantTotal(),
                c.isValide(),
                c.getReservation() != null ? c.getReservation().getIdReservation() : null,
                c.getPaiements().stream().map(paiementMapper::toResponse).toList());
    }
}