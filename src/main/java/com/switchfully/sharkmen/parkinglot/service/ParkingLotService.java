package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.domain.Address;
import com.switchfully.sharkmen.infrastructure.domain.PostalCode;
import com.switchfully.sharkmen.infrastructure.domain.AddressRepository;
import com.switchfully.sharkmen.infrastructure.domain.PostalCodeRepository;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.infrastructure.service.PostalCodeMapper;
import com.switchfully.sharkmen.parkinglot.ContactPerson;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parkinglot.domain.ContactPersonRepository;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLot;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.xml.validation.SchemaFactoryLoader;

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
        validatePhoneNumbers(parkingLotDto);
        ParkingLot parkingLot = parkingLotMapper.toParkingLot(parkingLotDto);

        postalCodeRepository.save(parkingLot.getAddress().getPostalCode());
        postalCodeRepository.save(parkingLot.getContactPerson().getAddress().getPostalCode());
        addressRepository.save(parkingLot.getAddress());
        addressRepository.save(parkingLot.getContactPerson().getAddress());
        contactPersonRepository.save(parkingLot.getContactPerson());
        parkingLotRepository.save(parkingLot);

        return parkingLotMapper.toCreateParkingLotResultDto(parkingLot);
    }

    private void validatePhoneNumbers(CreateParkingLotDto parkingLotDto) {
        if ((parkingLotDto.getCreateContactPersonDto().getMobilePhoneNumber() == null
                || parkingLotDto.getCreateContactPersonDto().getMobilePhoneNumber().isBlank())
                && (parkingLotDto.getCreateContactPersonDto().getPhoneNumber() == null
                || parkingLotDto.getCreateContactPersonDto().getPhoneNumber().isBlank())) {
            parkingLotServiceLogger.error("Phone numbers are null or blank, at least 1 need to be filled in");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Both phone numbers are blank or null");
        }
    }
}
