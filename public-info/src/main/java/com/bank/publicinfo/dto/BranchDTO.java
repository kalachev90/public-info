package com.bank.publicinfo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Time;

public class BranchDTO {
    @NotBlank(message = "Fill in the field")
    @Size(max = 370, message = "Should not exceed 370 symbols")
    private String address;

    @NotEmpty(message = "Fill in the field")
    private Long phoneNumber;

    @NotBlank(message = "Fill in the field")
    @Size(max = 250, message = "Should not exceed 250 symbols")
    private String city;

    @NotEmpty(message = "Fill in the field")
    private Time startOfWork;

    @NotEmpty(message = "Fill in the field")
    private Time endOfWork;

    public BranchDTO() {
    }

    public BranchDTO(String address, Long phoneNumber, String city, Time startOfWork, Time endOfWork) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Time getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(Time startOfWork) {
        this.startOfWork = startOfWork;
    }

    public Time getEndOfWork() {
        return endOfWork;
    }

    public void setEndOfWork(Time endOfWork) {
        this.endOfWork = endOfWork;
    }
}
