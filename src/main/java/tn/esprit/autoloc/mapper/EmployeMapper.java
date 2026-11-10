package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeRequestDTO;
import tn.esprit.autoloc.dto.EmployeResponseDTO;

@Component
public class EmployeMapper {

    public Employe toEntity(EmployeRequestDTO dto) {
        Employe e = new Employe();
        updateEntity(e, dto);
        return e;
    }

    public void updateEntity(Employe e, EmployeRequestDTO dto) {
        e.setNom(dto.nom());
        e.setPrenom(dto.prenom());
        e.setRole(dto.role());
    }

    public EmployeResponseDTO toResponse(Employe e) {
        return new EmployeResponseDTO(e.getIdEmploye(), e.getNom(), e.getPrenom(),
                e.getRole(), e.getAgence().getIdAgence());
    }
}