package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;

import java.time.LocalDate;
import java.util.UUID;

public class CreateMemberDto {
    private final String name;
    private final Address address;
    private final String phoneNumber;
    private final String emailAddress;
    private final String licensePlate;

    public CreateMemberDto(String name, Address address, String phoneNumber, String emailAddress, String licensePlate) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
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
}
