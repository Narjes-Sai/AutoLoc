package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.dto.EquipementRequestDTO;
import tn.esprit.autoloc.dto.EquipementResponseDTO;
import tn.esprit.autoloc.service.IEquipementService;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
@Tag(name = "Equipements", description = "Gestion des équipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @Operation(summary = "Lister les équipements")
    @GetMapping
    public List<EquipementResponseDTO> findAll() {
        return equipementService.findAll();
    }

    @Operation(summary = "Consulter un équipement")
    @GetMapping("/{id}")
    public EquipementResponseDTO findById(@PathVariable Long id) {
        return equipementService.findById(id);
    }

    @Operation(summary = "Créer un équipement")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquipementResponseDTO create(@Valid @RequestBody EquipementRequestDTO dto) {
        return equipementService.create(dto);
    }

    @Operation(summary = "Modifier un équipement")
    @PutMapping("/{id}")
    public EquipementResponseDTO update(@PathVariable Long id, @Valid @RequestBody EquipementRequestDTO dto) {
        return equipementService.update(id, dto);
    }

    @Operation(summary = "Supprimer un équipement")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        equipementService.deleteById(id);
    }
}