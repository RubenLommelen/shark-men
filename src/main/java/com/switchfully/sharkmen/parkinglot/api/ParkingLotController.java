package com.switchfully.sharkmen.parkinglot.api;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import com.switchfully.sharkmen.parkinglot.api.dto.ContactPersonDTO;
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
        return new ParkingLotResultDTO(1L, parkingLotDTO.getName(), parkingLotDTO.getCategory(), parkingLotDTO.getCapacity(), new ContactPersonDTO(1L,"", "", "", "", "", new AddressDto( "", "", new PostalCodeDto(  "3000", "Leuven"))), parkingLotDTO.getAddressDto());
    }
}
