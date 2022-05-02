package com.switchfully.sharkmen.parking_allocation.api;

import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("allocations")
public class ParkingAllocationController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateParkingAllocationResultDto startAllocation(@RequestBody CreateParkingAllocationDto createParkingAllocationDto) {
        return new CreateParkingAllocationResultDto(1L);
    }
}
