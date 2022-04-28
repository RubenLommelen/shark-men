package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;

import java.time.LocalDate;

public class MemberDto {
    private Long memberId;
    private String name;
    private Address address;
    private String phoneNumber;
    private String emailAddress;
    private String licensePlate;
    private LocalDate registrationDate;

    public MemberDto(Long memberId, String name, Address address, String phoneNumber, String emailAddress, String licensePlate, LocalDate registrationDate) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Long getMemberId() {
        return memberId;
    }
}
