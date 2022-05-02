package com.switchfully.sharkmen.parking_allocation.service;

import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocation;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingAllocationService {

    private final ParkingAllocationRepository parkingAllocationRepository;
    private final ParkingAllocationMapper parkingAllocationMapper;

    public ParkingAllocationService(ParkingAllocationRepository parkingAllocationRepository, ParkingAllocationMapper parkingAllocationMapper) {
        this.parkingAllocationRepository = parkingAllocationRepository;
        this.parkingAllocationMapper = parkingAllocationMapper;
    }

    public CreateParkingAllocationResultDto startAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        ParkingAllocation parkingAllocation = parkingAllocationMapper.toParkingAllocation(createParkingAllocationDto);
        parkingAllocationRepository.save(parkingAllocation);
        return parkingAllocationMapper.toDto(parkingAllocation);
    }
}
