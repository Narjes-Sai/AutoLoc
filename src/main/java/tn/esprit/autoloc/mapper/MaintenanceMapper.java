package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.dto.MaintenanceRequestDTO;
import tn.esprit.autoloc.dto.MaintenanceResponseDTO;

@Component
public class MaintenanceMapper {

    public Maintenance toEntity(MaintenanceRequestDTO dto) {
        Maintenance m = new Maintenance();
        updateEntity(m, dto);
        return m;
    }

    public void updateEntity(Maintenance m, MaintenanceRequestDTO dto) {
        m.setDateDebut(dto.dateDebut());
        m.setDateFin(dto.dateFin());
        m.setDescription(dto.description());
    }

    public MaintenanceResponseDTO toResponse(Maintenance m) {
        return new MaintenanceResponseDTO(m.getIdMaintenance(), m.getDateDebut(), m.getDateFin(),
                m.getDescription(), m.getVehicule().getIdVehicule());
    }
}