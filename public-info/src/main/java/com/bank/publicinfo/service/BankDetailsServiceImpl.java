package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.repository.BankDetailsRepository;
import com.bank.publicinfo.repository.CertificateRepository;
import com.bank.publicinfo.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class BankDetailsServiceImpl implements BankDetailsService {
    private final BankDetailsRepository bankDetailsRepository;
    private final LicenseRepository licenseRepository;
    private final CertificateRepository certificateRepository;

    @Autowired
    public BankDetailsServiceImpl(BankDetailsRepository bankDetailsRepository, LicenseRepository licenseRepository, CertificateRepository certificateRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
        this.licenseRepository = licenseRepository;
        this.certificateRepository = certificateRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankDetails> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BankDetails getBankDetailsById(Long id) {
        return bankDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bank details with id " + id + "not found"));
    }

    @Override
    public void createBankDetails(BankDetails bankDetails) {
        bankDetailsRepository.save(bankDetails);
    }

    @Override
    public void updateBankDetails(BankDetails bankDetails) {
        bankDetailsRepository.save(bankDetails);
    }

    @Override
    public void deleteBankDetails(Long id) {
        bankDetailsRepository.deleteById(id);
    }
}
