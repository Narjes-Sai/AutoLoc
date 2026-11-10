package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.dto.EquipementRequestDTO;
import tn.esprit.autoloc.dto.EquipementResponseDTO;

@Component
public class EquipementMapper {

    public Equipement toEntity(EquipementRequestDTO dto) {
        Equipement e = new Equipement();
        updateEntity(e, dto);
        return e;
    }

    public void updateEntity(Equipement e, EquipementRequestDTO dto) {
        e.setLibelle(dto.libelle());
    }

    public EquipementResponseDTO toResponse(Equipement e) {
        return new EquipementResponseDTO(e.getIdEquipement(), e.getLibelle());
    }
}