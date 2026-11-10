package tn.esprit.autoloc.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.MaintenanceRequestDTO;
import tn.esprit.autoloc.dto.MaintenanceResponseDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.MaintenanceMapper;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import tn.esprit.autoloc.repository.IVehiculeRepository;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final MaintenanceMapper maintenanceMapper;

    @Override
    public MaintenanceResponseDTO create(MaintenanceRequestDTO dto) {
        verifierRegles(dto);
        Maintenance maintenance = maintenanceMapper.toEntity(dto);
        maintenance.setVehicule(trouverVehicule(dto.idVehicule()));
        return maintenanceMapper.toResponse(maintenanceRepository.save(maintenance));
    }

    @Override
    public MaintenanceResponseDTO findById(Long id) {
        return maintenanceMapper.toResponse(trouver(id));
    }

    @Override
    public List<MaintenanceResponseDTO> findAll() {
        return maintenanceRepository.findAll().stream().map(maintenanceMapper::toResponse).toList();
    }

    @Override
    public MaintenanceResponseDTO update(Long id, MaintenanceRequestDTO dto) {
        Maintenance existant = trouver(id);
        verifierRegles(dto);
        maintenanceMapper.updateEntity(existant, dto);
        existant.setVehicule(trouverVehicule(dto.idVehicule()));
        return maintenanceMapper.toResponse(maintenanceRepository.save(existant));
    }

    @Override
    public void deleteById(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Maintenance", id);
        }
        maintenanceRepository.deleteById(id);
    }

    private Maintenance trouver(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance", id));
    }

    private Vehicule trouverVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", idVehicule));
    }

    private void verifierRegles(MaintenanceRequestDTO dto) {
        if (dto.dateFin() != null && dto.dateFin().isBefore(dto.dateDebut())) {
            throw new IllegalArgumentException("La date de fin ne peut pas précéder la date de début");
        }
    }
}