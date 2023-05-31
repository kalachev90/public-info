package com.bank.publicinfo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fill in the field")
    @Size(max = 370, message = "Should not exceed 370 symbols")
    @Column(name = "address", nullable = false)
    private String address;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "phone_number", unique = true, nullable = false)
    private Long phoneNumber;

    @NotBlank(message = "Fill in the field")
    @Size(max = 250, message = "Should not exceed 250 symbols")
    @Column(name = "city", nullable = false)
    private String city;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "start_of_work", nullable = false)
    private Time startOfWork;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "end_of_work", nullable = false)
    private Time endOfWork;

    @OneToMany(mappedBy = "atm")
    private List<Atm> atms = new ArrayList<>();

    public Branch() {
    }

    public Branch(String address, Long phoneNumber, String city, Time startOfWork, Time endOfWork) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
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

    public List<Atm> getAtms() {
        return atms;
    }

    public void setAtms(List<Atm> atms) {
        this.atms = atms;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                ", startOfWork=" + startOfWork +
                ", endOfWork=" + endOfWork +
                ", atms=" + atms +
                '}';
    }
}
