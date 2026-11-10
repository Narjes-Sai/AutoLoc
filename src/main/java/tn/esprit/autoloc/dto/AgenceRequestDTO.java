package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;

public record AgenceRequestDTO(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
        String nom,

        @NotBlank(message = "La ville est obligatoire")
        @Size(max = 50, message = "La ville ne doit pas dépasser 50 caractères")
        String ville,

        @NotBlank(message = "L'adresse est obligatoire")
        @Size(max = 150, message = "L'adresse ne doit pas dépasser 150 caractères")
        String adresse,

        @NotBlank(message = "Le téléphone est obligatoire")
        @Size(max = 20, message = "Le téléphone ne doit pas dépasser 20 caractères")
        String telephone
) {}