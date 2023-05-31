package com.bank.publicinfo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BankDetailsDTO {
    @NotEmpty(message = "Fill in the field")
    private Long bik;

    @NotEmpty(message = "Fill in the field")
    private Long inn;

    @NotEmpty(message = "Fill in the field")
    private Long kpp;

    @NotEmpty(message = "Fill in the field")
    private Integer corAccount;

    @NotBlank(message = "Fill in the field")
    @Size(max = 180, message = "Should not exceed 180 symbols")
    private String city;

    @NotBlank(message = "Fill in the field")
    @Size(max = 15, message = "Should not exceed 15 symbols")
    private String jointStockCompany;

    @NotBlank(message = "Fill in the field")
    @Size(max = 80, message = "Should not exceed 80 symbols")
    private String name;

    public BankDetailsDTO() {
    }

    public BankDetailsDTO(Long bik, Long inn, Long kpp, Integer corAccount, String city, String jointStockCompany, String name) {
        this.bik = bik;
        this.inn = inn;
        this.kpp = kpp;
        this.corAccount = corAccount;
        this.city = city;
        this.jointStockCompany = jointStockCompany;
        this.name = name;
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

    public Integer getCorAccount() {
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
}
