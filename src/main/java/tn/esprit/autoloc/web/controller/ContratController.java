package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.dto.ContratRequestDTO;
import tn.esprit.autoloc.dto.ContratResponseDTO;
import tn.esprit.autoloc.service.IContratService;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
@Tag(name = "Contrats", description = "Gestion des contrats")
public class ContratController {

    private final IContratService contratService;

    @Operation(summary = "Lister les contrats")
    @GetMapping
    public List<ContratResponseDTO> findAll() {
        return contratService.findAll();
    }

    @Operation(summary = "Consulter un contrat")
    @GetMapping("/{id}")
    public ContratResponseDTO findById(@PathVariable Long id) {
        return contratService.findById(id);
    }

    @Operation(summary = "Créer un contrat")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContratResponseDTO create(@Valid @RequestBody ContratRequestDTO dto) {
        return contratService.create(dto);
    }

    @Operation(summary = "Modifier un contrat")
    @PutMapping("/{id}")
    public ContratResponseDTO update(@PathVariable Long id, @Valid @RequestBody ContratRequestDTO dto) {
        return contratService.update(id, dto);
    }

    @Operation(summary = "Supprimer un contrat")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        contratService.deleteById(id);
    }
}