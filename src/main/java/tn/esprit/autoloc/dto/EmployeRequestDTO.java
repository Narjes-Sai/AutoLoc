package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;
import tn.esprit.autoloc.domain.RoleEmploye;

public record EmployeRequestDTO(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire")
        @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
        String prenom,

        @NotNull(message = "Le rôle est obligatoire")
        RoleEmploye role,

        @NotNull(message = "L'identifiant de l'agence est obligatoire")
        @Positive(message = "L'identifiant de l'agence doit être positif")
        Long idAgence
) {}