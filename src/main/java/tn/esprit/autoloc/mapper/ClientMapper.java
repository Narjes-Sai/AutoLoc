package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.dto.ClientRequestDTO;
import tn.esprit.autoloc.dto.ClientResponseDTO;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequestDTO dto) {
        Client c = new Client();
        updateEntity(c, dto);
        return c;
    }

    public void updateEntity(Client c, ClientRequestDTO dto) {
        c.setNom(dto.nom());
        c.setPrenom(dto.prenom());
        c.setEmail(dto.email());
        c.setTelephone(dto.telephone());
        c.setNumPermis(dto.numPermis());
        c.setDateInscription(dto.dateInscription());
    }

    public ClientResponseDTO toResponse(Client c) {
        return new ClientResponseDTO(c.getIdClient(), c.getNom(), c.getPrenom(), c.getEmail(),
                c.getTelephone(), c.getNumPermis(), c.getDateInscription());
    }
}