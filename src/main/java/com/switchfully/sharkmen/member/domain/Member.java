package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;

import java.time.LocalDate;
import java.util.Random;

public class Member {
    private final Long memberId;
    private final String name;
    private final Address address;
    private final String phoneNumber;
    private final String emailAddress;
    private final String licensePlate;
    private final LocalDate registrationDate;

    public Member(String name, Address address, String phoneNumber, String emailAddress, String licensePlate) {
        this.name = name;
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
}
