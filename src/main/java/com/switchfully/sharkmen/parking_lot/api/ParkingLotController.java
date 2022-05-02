package com.switchfully.sharkmen.parking_lot.api;

import com.switchfully.sharkmen.parking_lot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parking_lot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parking_lot.api.dto.ParkingLotOverviewDto;
import com.switchfully.sharkmen.parking_lot.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("parking-lots")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateParkingLotResultDto createParkingLot(@Valid @RequestBody CreateParkingLotDto parkingLotDto) {
        return parkingLotService.createParkingLot(parkingLotDto);
    }

    @GetMapping(produces = "application/json")
    public List<ParkingLotOverviewDto> getAllParkingLots() {
        return parkingLotService.getAllParkingLots();
    }
}
