package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.member.domain.LicensePlate;

public class CreateMemberDto {
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final String phoneNumber;
    private final String emailAddress;
    private final LicensePlate licensePlate;

    public CreateMemberDto(String firstName, String lastName, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {return lastName; }

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


}
