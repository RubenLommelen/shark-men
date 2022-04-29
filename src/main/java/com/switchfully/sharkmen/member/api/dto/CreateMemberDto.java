package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.LicensePlateDto;

public class CreateMemberDto {
    private final String firstName;
    private final String lastName;
    private final AddressDto address;
    private final String phoneNumber;
    private final String emailAddress;
    private final LicensePlateDto licensePlate;

    public CreateMemberDto(String firstName, String lastName, AddressDto address, String phoneNumber, String emailAddress, LicensePlateDto licensePlate) {
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

    public String getLastName() {
        return lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }


}
