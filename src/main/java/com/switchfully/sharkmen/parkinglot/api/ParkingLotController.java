package com.switchfully.sharkmen.parkinglot.api;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import com.switchfully.sharkmen.parkinglot.api.dto.ContactPersonDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotResultDTO;
import com.switchfully.sharkmen.parkinglot.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parking-lots")
public class ParkingLotController {

    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotResultDTO createParkingLot(@RequestBody CreateParkingLotDTO parkingLotDTO) {
        return parkingLotService.createParkingLot(parkingLotDTO);
    }
}
