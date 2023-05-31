package com.bank.publicinfo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "photo", nullable = false)
    private Byte photo;

    @ManyToOne
    @JoinColumn(name = "bank_details_id", referencedColumnName = "id")
    private BankDetails certificate;

    public Certificate() {
    }

    public Certificate(Byte photo, BankDetails certificate) {
        this.photo = photo;
        this.certificate = certificate;
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

    public BankDetails getCertificate() {
        return certificate;
    }

    public void setCertificate(BankDetails certificate) {
        this.certificate = certificate;
    }
}
