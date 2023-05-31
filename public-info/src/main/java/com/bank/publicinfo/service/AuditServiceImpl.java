package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Audit getAuditById(Long id) {
        return auditRepository.findById(id).orElse(null);
    }

    @Override
    public void createAudit(Audit audit) {
        auditRepository.save(audit);
    }
}
