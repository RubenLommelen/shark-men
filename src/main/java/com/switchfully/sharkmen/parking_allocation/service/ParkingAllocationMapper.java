package com.switchfully.sharkmen.parking_allocation.service;

import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocation;
import org.springframework.stereotype.Component;

@Component
public class ParkingAllocationMapper {
    public ParkingAllocation toParkingAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        return new ParkingAllocation(
                createParkingAllocationDto.getMemberId(),
                createParkingAllocationDto.getLicensePlateNumber(),
                createParkingAllocationDto.getParkingLotId()
        );
    }

    public CreateParkingAllocationResultDto toDto(ParkingAllocation parkingAllocation) {
        return new CreateParkingAllocationResultDto(parkingAllocation.getId());
    }
}
