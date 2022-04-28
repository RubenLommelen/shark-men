package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.member.domain.LicensePlate;

import java.time.LocalDate;

public class MemberDto {
    private final Long memberId;
    private final String name;
    private final Address address;
    private final String phoneNumber;
    private final String emailAddress;
    private final LicensePlate licensePlate;
    private final LocalDate registrationDate;

    public MemberDto(Long memberId, String name, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate, LocalDate registrationDate) {
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

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Long getMemberId() {
        return memberId;
    }
}