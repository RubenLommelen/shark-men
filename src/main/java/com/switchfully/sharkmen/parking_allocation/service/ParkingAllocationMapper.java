package com.switchfully.sharkmen.parking_allocation.service;

import com.switchfully.sharkmen.member.service.MemberMapper;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocation;
import com.switchfully.sharkmen.parking_lot.service.ParkingLotMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ParkingAllocationMapper {
    private final Logger parkingAllocationServiceLogger = LoggerFactory.getLogger(ParkingAllocationService.class);
    private final MemberMapper memberMapper;
    private final ParkingLotMapper parkingLotMapper;

    public ParkingAllocationMapper(MemberMapper memberMapper, ParkingLotMapper parkingLotMapper) {
        this.memberMapper = memberMapper;
        this.parkingLotMapper = parkingLotMapper;
    }

    public ParkingAllocation toParkingAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        parkingAllocationServiceLogger.info("CreateParkingAllocationDto conversion to Parking allocation");
        return new ParkingAllocation(

                memberMapper.toMember(createParkingAllocationDto.getMemberId()),
                createParkingAllocationDto.getLicensePlateNumber(),
                parkingLotMapper.toParkingLot(createParkingAllocationDto.getParkingLotId())

        );
    }

    public CreateParkingAllocationResultDto toDto(ParkingAllocation parkingAllocation) {
        parkingAllocationServiceLogger.info("ParkingAllocation conversion to CreateParkingAllocationResultDto");
        return new CreateParkingAllocationResultDto(parkingAllocation.getId());
    }
}
