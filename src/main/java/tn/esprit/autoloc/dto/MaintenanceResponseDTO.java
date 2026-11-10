package tn.esprit.autoloc.dto;

import java.time.LocalDate;

public record MaintenanceResponseDTO(
        Long idMaintenance,
        LocalDate dateDebut,
        LocalDate dateFin,
        String description,
        Long idVehicule
) {}