package com.switchfully.sharkmen.parking_allocation.api.dto;

public class CreateParkingAllocationDto {
    private Long memberId;
    private String licensePlateNumber;
    private Long parkingLotId;

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
