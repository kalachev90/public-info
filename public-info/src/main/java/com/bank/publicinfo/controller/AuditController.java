package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AuditDTO;
import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.service.AuditService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {
    private final Logger logger = LoggerFactory.getLogger(AuditController.class);
    private final AuditService auditService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuditController(AuditService auditService, ModelMapper modelMapper) {
        this.auditService = auditService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<AuditDTO> getAllAudits() {
        logger.info("Received request to get all audits.");
        List<Audit> audits = auditService.getAllAudits();
        logger.info("Returning {} audits.", audits.size());
        return audits.stream().map(this::convertToAuditDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuditDTO getAuditById(@PathVariable("id") Long id) {
        logger.info("Received request to get audit with id {}.", id);
        Audit audit = auditService.getAuditById(id);
        logger.info("Returning audit with id {}.", id);
        return convertToAuditDTO(audit);
    }

    @PostMapping
    public ResponseEntity<AuditDTO> createAudit(@RequestBody AuditDTO auditDTO) {
        logger.info("Received request to create audit.");
        auditService.createAudit(convertToAudit(auditDTO));
        logger.info("Audit created successfully.");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private Audit convertToAudit(AuditDTO auditDTO) {
        return modelMapper.map(auditDTO, Audit.class);
    }

    private AuditDTO convertToAuditDTO(Audit audit) {
        return modelMapper.map(audit, AuditDTO.class);
    }
}
