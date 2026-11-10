package tn.esprit.autoloc.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.dto.PaiementRequestDTO;
import tn.esprit.autoloc.dto.PaiementResponseDTO;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.PaiementMapper;
import tn.esprit.autoloc.repository.IContratRepository;
import tn.esprit.autoloc.repository.IPaiementRepository;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;
    private final IContratRepository contratRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public PaiementResponseDTO create(PaiementRequestDTO dto) {
        Paiement paiement = paiementMapper.toEntity(dto);
        paiement.setContrat(trouverContrat(dto.idContrat()));
        return paiementMapper.toResponse(paiementRepository.save(paiement));
    }

    @Override
    public PaiementResponseDTO findById(Long id) {
        return paiementMapper.toResponse(trouver(id));
    }

    @Override
    public List<PaiementResponseDTO> findAll() {
        return paiementRepository.findAll().stream().map(paiementMapper::toResponse).toList();
    }

    @Override
    public PaiementResponseDTO update(Long id, PaiementRequestDTO dto) {
        Paiement existant = trouver(id);
        paiementMapper.updateEntity(existant, dto);
        existant.setContrat(trouverContrat(dto.idContrat()));
        return paiementMapper.toResponse(paiementRepository.save(existant));
    }

    @Override
    public void deleteById(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paiement", id);
        }
        paiementRepository.deleteById(id);
    }

    private Paiement trouver(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement", id));
    }

    private Contrat trouverContrat(Long idContrat) {
        return contratRepository.findById(idContrat)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", idContrat));
    }
}