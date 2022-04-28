package com.switchfully.sharkmen.parkinglot.api;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.parkinglot.ContactPerson;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parking-lots")
public class ParkingLotController {

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotResultDTO createParkingLot(@RequestBody CreateParkingLotDTO parkingLotDTO) {
        return new ParkingLotResultDTO(1, parkingLotDTO.getName(), parkingLotDTO.getCategory(), parkingLotDTO.getCapacity(), new ContactPerson(1, "", "", "", "", new Address(1, "", "", new PostalCode(1, "3000", "Leuven"))), parkingLotDTO.getAddress());
    }
}
