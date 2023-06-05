package com.bank.publicinfo.util;

import com.bank.publicinfo.dto.*;
import com.bank.publicinfo.entity.*;
import org.modelmapper.ModelMapper;

public class Mapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Atm convertToAtm(AtmDTO atmDTO) {
        return modelMapper.map(atmDTO, Atm.class);
    }

    public AtmDTO convertToAtmDTO(Atm atm) {
        return modelMapper.map(atm, AtmDTO.class);
    }

    public Audit convertToAudit(AuditDTO auditDTO) {
        return modelMapper.map(auditDTO, Audit.class);
    }

    public AuditDTO convertToAuditDTO(Audit audit) {
        return modelMapper.map(audit, AuditDTO.class);
    }

    public BankDetails convertToBankDetails(BankDetailsDTO bankDetailsDTO) {
        return modelMapper.map(bankDetailsDTO, BankDetails.class);
    }

    public BankDetailsDTO convertToBankDetailsDTO(BankDetails bankDetails) {
        return modelMapper.map(bankDetails, BankDetailsDTO.class);
    }

    public Branch convertToBranch(BranchDTO branchDTO) {
        return modelMapper.map(branchDTO, Branch.class);
    }

    public BranchDTO convertToBranchDTO(Branch branch) {
        return modelMapper.map(branch, BranchDTO.class);
    }

    public Certificate convertToCertificate(CertificateDTO certificateDTO) {
        return modelMapper.map(certificateDTO, Certificate.class);
    }

    public CertificateDTO convertToCertificateDTO(Certificate certificate) {
        return modelMapper.map(certificate, CertificateDTO.class);
    }

    public License convertToLicense(LicenseDTO licenseDTO) {
        return modelMapper.map(licenseDTO, License.class);
    }

    public LicenseDTO convertToLicenseDTO(License license) {
        return modelMapper.map(license, LicenseDTO.class);
    }
}
