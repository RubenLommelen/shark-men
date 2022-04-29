package com.switchfully.sharkmen.member.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.CreateLicensePlateDto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateMemberDto {
    @NotBlank(message = "FirstName is blank or null")
    private final String firstName;
    @NotBlank(message = "LastName is blank or null")
    private final String lastName;
    @Valid
    @NotNull(message = "Address is null or blank")
    private final CreateAddressDto address;
    @NotBlank(message = "PhoneNumber is blank or null")
    private final String phoneNumber;
    @Email(regexp = "^(\\S+)@(\\S+)\\.([a-zA-Z]+)$", message = "email is not in the right format")
    private final String emailAddress;
    @Valid
    @NotNull(message = "LicensePlate is null or blank")
    private final CreateLicensePlateDto licensePlate;

    public CreateMemberDto(String firstName, String lastName, CreateAddressDto address, String phoneNumber, String emailAddress, CreateLicensePlateDto createLicensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = createLicensePlate;
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


}
