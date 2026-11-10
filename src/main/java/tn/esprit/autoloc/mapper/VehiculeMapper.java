package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.dto.VehiculeRequestDTO;
import tn.esprit.autoloc.dto.VehiculeResponseDTO;

@Component
public class VehiculeMapper {

    public Vehicule toEntity(VehiculeRequestDTO dto) {
        Vehicule v = new Vehicule();
        updateEntity(v, dto);
        return v;
    }

    public void updateEntity(Vehicule v, VehiculeRequestDTO dto) {
        v.setImmatriculation(dto.immatriculation());
        v.setMarque(dto.marque());
        v.setModele(dto.modele());
        v.setCategorie(dto.categorie());
        v.setTarifJournalier(dto.tarifJournalier());
        v.setStatut(dto.statut());
    }

    public VehiculeResponseDTO toResponse(Vehicule v) {
        return new VehiculeResponseDTO(
                v.getIdVehicule(),
                v.getImmatriculation(),
                v.getMarque(),
                v.getModele(),
                v.getCategorie(),
                v.getTarifJournalier(),
                v.getStatut());
    }
}