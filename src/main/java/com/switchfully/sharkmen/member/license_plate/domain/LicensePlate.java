package com.switchfully.sharkmen.member.license_plate.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "LICENSE_PLATE")
public class LicensePlate {
    @Transient
    private final Logger licensePlateLogger = LoggerFactory.getLogger(LicensePlate.class);
    @Id
    @GeneratedValue
    private Long licensePlateId;
    @Column(name = "LICENSE_PLATE_NUMBER")
    private String licensePlateNumber;
    @Column(name = "COUNTRY")
    private String country;

    public LicensePlate(String licensePlateNumber, String country) {
        fieldsNullCheck(licensePlateNumber, country);
        this.licensePlateNumber = licensePlateNumber;
        this.country = country;
    }

    public LicensePlate() {
    }

    private void fieldsNullCheck(String licensePlateNumber, String country) {
        if (licensePlateNumber == null) {
            licensePlateLogger.error("License plate number is null");
            throw new NullPointerException("Please provide a license plate number !");
        }
        if (country == null) {
            licensePlateLogger.error("Country is null");
            throw new NullPointerException("Please provide a country !");
        }
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getCountry() {
        return country;
    }
}
