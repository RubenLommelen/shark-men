package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;

import java.time.LocalDate;
import java.util.Random;

public class Member {
    private final Long memberId;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final String phoneNumber;
    private final String emailAddress;
    private final LicensePlate licensePlate;
    private final LocalDate registrationDate;

    public Member(String firstName, String lastName, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.memberId = new Random().nextLong();
        this.registrationDate = LocalDate.now();
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
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
}
