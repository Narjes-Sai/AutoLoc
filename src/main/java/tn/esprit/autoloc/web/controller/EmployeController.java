package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.dto.EmployeRequestDTO;
import tn.esprit.autoloc.dto.EmployeResponseDTO;
import tn.esprit.autoloc.service.IEmployeService;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
@Tag(name = "Employés", description = "Gestion des employés")
public class EmployeController {

    private final IEmployeService employeService;

    @Operation(summary = "Lister les employés")
    @GetMapping
    public List<EmployeResponseDTO> findAll() {
        return employeService.findAll();
    }

    @Operation(summary = "Consulter un employé")
    @GetMapping("/{id}")
    public EmployeResponseDTO findById(@PathVariable Long id) {
        return employeService.findById(id);
    }

    @Operation(summary = "Créer un employé")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeResponseDTO create(@Valid @RequestBody EmployeRequestDTO dto) {
        return employeService.create(dto);
    }

    @Operation(summary = "Modifier un employé")
    @PutMapping("/{id}")
    public EmployeResponseDTO update(@PathVariable Long id, @Valid @RequestBody EmployeRequestDTO dto) {
        return employeService.update(id, dto);
    }

    @Operation(summary = "Supprimer un employé")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        employeService.deleteById(id);
    }
}