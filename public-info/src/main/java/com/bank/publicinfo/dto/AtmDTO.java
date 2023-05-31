package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.Branch;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Time;

public class AtmDTO {
    @NotBlank(message = "Fill in the field")
    @Size(max = 370, message = "Should not exceed 370 symbols")
    private String address;

    private Time startOfWork;

    private Time endOfWork;

    @NotEmpty
    private Boolean allHours;

    private Branch atm;

    public AtmDTO() {
    }

    public AtmDTO(String address, Time startOfWork, Time endOfWork, Boolean allHours, Branch atm) {
        this.address = address;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
        this.allHours = allHours;
        this.atm = atm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Boolean getAllHours() {
        return allHours;
    }

    public void setAllHours(Boolean allHours) {
        this.allHours = allHours;
    }

    public Branch getAtm() {
        return atm;
    }

    public void setAtm(Branch atm) {
        this.atm = atm;
    }
}
