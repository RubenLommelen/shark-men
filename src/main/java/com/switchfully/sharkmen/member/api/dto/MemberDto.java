package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.LicensePlateDto;

import java.time.OffsetDateTime;

public class MemberDto {
    private final Long memberId;
    private final String name;
    private final AddressDto address;
    private final String phoneNumber;
    private final String emailAddress;
    private final LicensePlateDto licensePlate;
    private final OffsetDateTime registrationDate;

    public MemberDto(Long memberId, String name, AddressDto address, String phoneNumber, String emailAddress, LicensePlateDto licensePlate, OffsetDateTime registrationDate) {
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

    public OffsetDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Long getMemberId() {
        return memberId;
    }
}
