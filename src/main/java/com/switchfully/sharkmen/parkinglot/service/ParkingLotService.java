package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.domain.AddressRepository;
import com.switchfully.sharkmen.infrastructure.domain.PostalCodeRepository;
import com.switchfully.sharkmen.infrastructure.exceptions.PhoneNumbersMissingException;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.contact_person.domain.ContactPersonRepository;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLot;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingLotService {
    private final Logger parkingLotServiceLogger = LoggerFactory.getLogger(ParkingLotService.class);

    private final ParkingLotMapper parkingLotMapper;

    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotMapper parkingLotMapper, ParkingLotRepository parkingLotRepository) {
        this.parkingLotMapper = parkingLotMapper;
        this.parkingLotRepository = parkingLotRepository;
    }

    public CreateParkingLotResultDto createParkingLot(CreateParkingLotDto parkingLotDto) {
        parkingLotServiceLogger.info("Started creating ParkingLot");
        validatePhoneNumbers(parkingLotDto);
        ParkingLot parkingLot = parkingLotMapper.toParkingLot(parkingLotDto);

        parkingLotServiceLogger.info("Saving ParkingLot in the database");
        parkingLotRepository.save(parkingLot);

        parkingLotServiceLogger.info("Successfully created ParkingLot (id: " + parkingLot.getId() + ")");
        return parkingLotMapper.toCreateParkingLotResultDto(parkingLot);
    }

    private void validatePhoneNumbers(CreateParkingLotDto parkingLotDto) {
        if ((parkingLotDto.getCreateContactPersonDto().getMobilePhoneNumber() == null
                || parkingLotDto.getCreateContactPersonDto().getMobilePhoneNumber().isBlank())
                && (parkingLotDto.getCreateContactPersonDto().getPhoneNumber() == null
                || parkingLotDto.getCreateContactPersonDto().getPhoneNumber().isBlank())) {
            parkingLotServiceLogger.error("Phone numbers are null or blank, at least 1 needs to be filled in");
            throw new PhoneNumbersMissingException("Both phone numbers are blank or null");
        }
    }
}
