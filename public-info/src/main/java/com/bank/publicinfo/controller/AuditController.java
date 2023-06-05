package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AuditDTO;
import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.service.AuditService;
import com.bank.publicinfo.util.Mapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
@Tag(name="Аудит", description="Работа с аудитом")
public class AuditController {
    private final Logger logger = LoggerFactory.getLogger(AuditController.class);
    private final AuditService auditService;
    private final Mapper mapper = new Mapper();

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    @Operation(summary = "Получение списка всех записей аудита", description = "Позволяет получить список всех записей аудита")
    public List<AuditDTO> getAllAudits() {
        logger.info("Received request to get all Audits.");
        List<Audit> audits = auditService.getAllAudits();
        logger.info("Returning {} Audits.", audits.size());
        return audits.stream().map(mapper::convertToAuditDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение одной записи аудита", description = "Позволяет получить одну запись аудита")
    public AuditDTO getAuditById(@PathVariable("id") Long id) {
        logger.info("Received request to get Audit with id {}.", id);
        Audit audit = auditService.getAuditById(id);
        logger.info("Returning Audit with id {}.", id);
        return mapper.convertToAuditDTO(audit);
    }

    @PostMapping
    @Operation(summary = "Добавление новой записи аудита", description = "Позволяет добавить новую запись аудита")
    public Audit createAudit(@RequestBody AuditDTO auditDTO) {
        Audit audit = mapper.convertToAudit(auditDTO);
        logger.info("Received request to create new Audit");
        auditService.createAudit(audit);
        logger.info("Audit created successfully");
        return audit;
    }
}
