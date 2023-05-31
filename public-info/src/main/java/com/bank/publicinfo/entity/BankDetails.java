package com.bank.publicinfo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_details")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "bik", unique = true, nullable = false)
    private Long bik;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "inn", unique = true, nullable = false)
    private Long inn;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "kpp", unique = true, nullable = false)
    private Long kpp;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "cor_account", unique = true, nullable = false)
    private Integer corAccount;

    @NotBlank(message = "Fill in the field")
    @Size(max = 180, message = "Should not exceed 180 symbols")
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "Fill in the field")
    @Size(max = 15, message = "Should not exceed 15 symbols")
    @Column(name = "joint_stock_company", nullable = false)
    private String jointStockCompany;

    @NotBlank(message = "Fill in the field")
    @Size(max = 80, message = "Should not exceed 80 symbols")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "license")
    private List<License> licenses = new ArrayList<>();

    @OneToMany(mappedBy = "certificate")
    private List<Certificate> certificates = new ArrayList<>();

    public BankDetails() {
    }

    public BankDetails(Long bik, Long inn, Long kpp, Integer corAccount, String city, String jointStockCompany, String name) {
        this.bik = bik;
        this.inn = inn;
        this.kpp = kpp;
        this.corAccount = corAccount;
        this.city = city;
        this.jointStockCompany = jointStockCompany;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBik() {
        return bik;
    }

    public void setBik(Long bik) {
        this.bik = bik;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public int getCorAccount() {
        return corAccount;
    }

    public void setCorAccount(Integer corAccount) {
        this.corAccount = corAccount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJointStockCompany() {
        return jointStockCompany;
    }

    public void setJointStockCompany(String jointStockCompany) {
        this.jointStockCompany = jointStockCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "id=" + id +
                ", bik=" + bik +
                ", inn=" + inn +
                ", kpp=" + kpp +
                ", corAccount=" + corAccount +
                ", city='" + city + '\'' +
                ", jointStockCompany='" + jointStockCompany + '\'' +
                ", name='" + name + '\'' +
                ", licenses=" + licenses +
                ", certificates=" + certificates +
                '}';
    }
}
