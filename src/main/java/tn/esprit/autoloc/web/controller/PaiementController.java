package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.dto.PaiementRequestDTO;
import tn.esprit.autoloc.dto.PaiementResponseDTO;
import tn.esprit.autoloc.service.IPaiementService;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
@Tag(name = "Paiements", description = "Gestion des paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @Operation(summary = "Lister les paiements")
    @GetMapping
    public List<PaiementResponseDTO> findAll() {
        return paiementService.findAll();
    }

    @Operation(summary = "Consulter un paiement")
    @GetMapping("/{id}")
    public PaiementResponseDTO findById(@PathVariable Long id) {
        return paiementService.findById(id);
    }

    @Operation(summary = "Créer un paiement")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaiementResponseDTO create(@Valid @RequestBody PaiementRequestDTO dto) {
        return paiementService.create(dto);
    }

    @Operation(summary = "Modifier un paiement")
    @PutMapping("/{id}")
    public PaiementResponseDTO update(@PathVariable Long id, @Valid @RequestBody PaiementRequestDTO dto) {
        return paiementService.update(id, dto);
    }

    @Operation(summary = "Supprimer un paiement")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        paiementService.deleteById(id);
    }
}