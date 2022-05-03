package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.member.domain.MembershipLevel;
import com.switchfully.sharkmen.member.license_plate.api.dto.CreateLicensePlateDto;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateMemberDto {
    @Transient
    public static final MembershipLevel DEFAULT_MEMBERSHIP_LEVEL = MembershipLevel.BRONZE;

    @NotBlank(message = "FirstName is blank or null")
    private final String firstName;
    @NotBlank(message = "LastName is blank or null")
    private final String lastName;
    @Valid
    @NotNull(message = "Address is null or blank")
    private final CreateAddressDto address;
    @NotBlank(message = "PhoneNumber is blank or null")
    private final String phoneNumber;
    @Email(regexp = "^(\\S+)@(\\S+)\\.([a-zA-Z]+)$", message = "email is not in the right format. Please provide a correct E-mail address ")
    private final String emailAddress;
    @Valid
    @NotNull(message = "LicensePlate is null or blank")
    private final CreateLicensePlateDto licensePlate;
    private MembershipLevel membershipLevel;

    public CreateMemberDto(String firstName, String lastName, CreateAddressDto address, String phoneNumber, String emailAddress, CreateLicensePlateDto licensePlate, MembershipLevel membershipLevel) {
        if (membershipLevel == null) {
            membershipLevel = DEFAULT_MEMBERSHIP_LEVEL;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateAddressDto getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public CreateLicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }
}
