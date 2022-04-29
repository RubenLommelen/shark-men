package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.domain.AddressRepository;
import com.switchfully.sharkmen.infrastructure.domain.PostalCodeRepository;
import com.switchfully.sharkmen.infrastructure.exceptions.PhoneNumbersMissingException;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.infrastructure.service.PostalCodeMapper;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parkinglot.domain.ContactPersonRepository;
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

    private final AddressMapper addressMapper;
    private final PostalCodeMapper postalCodeMapper;
    private final ParkingLotMapper parkingLotMapper;
    private final ContactPersonMapper contactPersonMapper;

    private final AddressRepository addressRepository;
    private final PostalCodeRepository postalCodeRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ContactPersonRepository contactPersonRepository;

    public ParkingLotService(AddressMapper addressMapper, PostalCodeMapper postalCodeMapper, ParkingLotMapper parkingLotMapper, ContactPersonMapper contactPersonMapper, AddressRepository addressRepository, PostalCodeRepository postalCodeRepository, ParkingLotRepository parkingLotRepository, ContactPersonRepository contactPersonRepository) {
        this.addressMapper = addressMapper;
        this.postalCodeMapper = postalCodeMapper;
        this.parkingLotMapper = parkingLotMapper;
        this.contactPersonMapper = contactPersonMapper;
        this.addressRepository = addressRepository;
        this.postalCodeRepository = postalCodeRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.contactPersonRepository = contactPersonRepository;
    }

    public CreateParkingLotResultDto createParkingLot(CreateParkingLotDto parkingLotDto) {
        parkingLotServiceLogger.info("Started creating CreateParkingLotResultDto");
        validatePhoneNumbers(parkingLotDto);
        ParkingLot parkingLot = parkingLotMapper.toParkingLot(parkingLotDto);

        postalCodeRepository.save(parkingLot.getAddress().getPostalCode());
        postalCodeRepository.save(parkingLot.getContactPerson().getAddress().getPostalCode());
        addressRepository.save(parkingLot.getAddress());
        addressRepository.save(parkingLot.getContactPerson().getAddress());
        contactPersonRepository.save(parkingLot.getContactPerson());
        parkingLotRepository.save(parkingLot);

        parkingLotServiceLogger.info("Successfully created CreateParkingLotResultDto (id: " + parkingLot.getId() + ")");
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
