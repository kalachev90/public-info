package com.bank.publicinfo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "license")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "photo", nullable = false)
    private Byte photo;

    @ManyToOne
    @JoinColumn(name = "bank_details_id", referencedColumnName = "id")
    private BankDetails license;

    public License() {
    }

    public License(Byte photo, BankDetails license) {
        this.photo = photo;
        this.license = license;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getPhoto() {
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
