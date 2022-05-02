package com.switchfully.sharkmen.parking_allocation.domain;

import java.time.OffsetDateTime;

public class ParkingAllocation {
    private Long id;
    private Long memberId;
    private String licensePlateNumber;
    private Long parkingLotId;
    private OffsetDateTime startTime;

    public ParkingAllocation(Long memberId, String licensePlateNumber, Long parkingLotId) {
        this.id = memberId;
        this.memberId = memberId;
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLotId = parkingLotId;
        this.startTime = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }
}
