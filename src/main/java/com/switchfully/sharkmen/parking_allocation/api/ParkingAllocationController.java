package com.switchfully.sharkmen.parking_allocation.api;

import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import com.switchfully.sharkmen.parking_allocation.service.ParkingAllocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("allocations")
public class ParkingAllocationController {

    private final ParkingAllocationService parkingAllocationService;

    public ParkingAllocationController(ParkingAllocationService parkingAllocationService) {
        this.parkingAllocationService = parkingAllocationService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateParkingAllocationResultDto startAllocation(@RequestBody CreateParkingAllocationDto createParkingAllocationDto) {
        return parkingAllocationService.startAllocation(createParkingAllocationDto);
    }
}
