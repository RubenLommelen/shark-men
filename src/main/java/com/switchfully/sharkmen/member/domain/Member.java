package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;

import java.time.LocalDate;
import java.util.UUID;

public class Member {
    private String memberId;
    private String name;
    private Address address;
    private String phoneNumber;
    private String emailAddress;
    private String licensePlate;
    private LocalDate registrationDate;

    public Member(String name, Address address, String phoneNumber, String emailAddress, String licensePlate) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.memberId = UUID.randomUUID().toString();
        this.registrationDate = LocalDate.now();
    }

    public String getMemberId() {
        return memberId;
    }
}
