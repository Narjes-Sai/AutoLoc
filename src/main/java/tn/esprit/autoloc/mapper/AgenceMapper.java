package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceRequestDTO;
import tn.esprit.autoloc.dto.AgenceResponseDTO;

@Component
public class AgenceMapper {

    public Agence toEntity(AgenceRequestDTO dto) {
        Agence a = new Agence();
        updateEntity(a, dto);
        return a;
    }

    public void updateEntity(Agence a, AgenceRequestDTO dto) {
        a.setNom(dto.nom());
        a.setVille(dto.ville());
        a.setAdresse(dto.adresse());
        a.setTelephone(dto.telephone());
    }

    public AgenceResponseDTO toResponse(Agence a) {
        return new AgenceResponseDTO(a.getIdAgence(), a.getNom(), a.getVille(),
                a.getAdresse(), a.getTelephone());
    }
}