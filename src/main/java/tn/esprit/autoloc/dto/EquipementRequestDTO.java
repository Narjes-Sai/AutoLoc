package tn.esprit.autoloc.dto;

import jakarta.validation.constraints.*;

public record EquipementRequestDTO(
        @NotBlank(message = "Le libellé est obligatoire")
        @Size(max = 100, message = "Le libellé ne doit pas dépasser 100 caractères")
        String libelle
) {}