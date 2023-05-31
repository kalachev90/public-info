package com.bank.publicinfo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Time;

@Entity
@Table(name = "atm")
public class Atm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fill in the field")
    @Size(max = 370, message = "Should not exceed 370 symbols")
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "start_of_work")
    private Time startOfWork;

    @Column(name = "end_of_work")
    private Time endOfWork;

    @NotEmpty
    @Column(name = "all_hours", nullable = false)
    private Boolean allHours;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch atm;

    public Atm() {
    }

    public Atm(String address, Time startOfWork, Time endOfWork, Boolean allHours, Branch atm) {
        this.address = address;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
        this.allHours = allHours;
        this.atm = atm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
