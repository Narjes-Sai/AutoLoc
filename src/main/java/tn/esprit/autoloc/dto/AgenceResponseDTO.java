package tn.esprit.autoloc.dto;

public record AgenceResponseDTO(
        Long idAgence,
        String nom,
        String ville,
        String adresse,
        String telephone
) {}