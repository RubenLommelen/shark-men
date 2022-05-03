package com.switchfully.sharkmen.parking_allocation.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateParkingAllocationDto {
    @NotNull(message = "MemberId is null")
    private final Long memberId;
    @NotBlank(message = "LicensePlateNumber is blank or null")
    private final String licensePlateNumber;
    @NotNull(message = "ParkingLotId is null")
    private final Long parkingLotId;

    public CreateParkingAllocationDto(Long memberId, String licensePlateNumber, Long parkingLotId) {
        this.memberId = memberId;
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLotId = parkingLotId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }
}
