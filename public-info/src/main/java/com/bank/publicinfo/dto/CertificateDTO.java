package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetails;

import javax.validation.constraints.NotEmpty;

public class CertificateDTO {
    @NotEmpty(message = "Fill in the field")
    private Byte photo;

    private BankDetails certificate;

    public CertificateDTO() {
    }

    public CertificateDTO(Byte photo, BankDetails certificate) {
        this.photo = photo;
        this.certificate = certificate;
    }

    public Byte getPhoto() {
        return photo;
    }

    public void setPhoto(Byte photo) {
        this.photo = photo;
    }

    public BankDetails getCertificate() {
        return certificate;
    }

    public void setCertificate(BankDetails certificate) {
        this.certificate = certificate;
    }
}
