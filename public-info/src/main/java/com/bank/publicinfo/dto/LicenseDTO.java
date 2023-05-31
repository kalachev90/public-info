package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetails;

import javax.validation.constraints.NotEmpty;

public class LicenseDTO {
    @NotEmpty(message = "Fill in the field")
    private Byte photo;

    private BankDetails license;

    public LicenseDTO() {
    }

    public LicenseDTO(Byte photo, BankDetails license) {
        this.photo = photo;
        this.license = license;
    }

    public Byte getPhoto() {
        return photo;
    }

    public void setPhoto(Byte photo) {
        this.photo = photo;
    }

    public BankDetails getLicense() {
        return license;
    }

    public void setLicense(BankDetails license) {
        this.license = license;
    }
}
