package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.dto.ReservationRequestDTO;
import tn.esprit.autoloc.dto.ReservationResponseDTO;

@Component
public class ReservationMapper {

    public Reservation toEntity(ReservationRequestDTO dto) {
        Reservation r = new Reservation();
        updateEntity(r, dto);
        return r;
    }

    public void updateEntity(Reservation r, ReservationRequestDTO dto) {
        r.setDateDebut(dto.dateDebut());
        r.setDateFin(dto.dateFin());
        r.setStatut(dto.statut());
    }

    public ReservationResponseDTO toResponse(Reservation r) {
        return new ReservationResponseDTO(r.getIdReservation(), r.getDateDebut(), r.getDateFin(),
                r.getStatut(), r.getClient().getIdClient(), r.getVehicule().getIdVehicule());
    }
}