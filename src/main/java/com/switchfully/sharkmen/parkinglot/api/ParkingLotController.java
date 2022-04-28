package com.switchfully.sharkmen.parkinglot.api;

import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parking-lots")
public class ParkingLotController {

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDTO createParkingLot(@RequestBody ParkingLotDTO parkingLotDTO) {
        return parkingLotDTO;
    }
}
