package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.infrastructure.domain.AddressRepository;
import com.switchfully.sharkmen.infrastructure.domain.PostalCodeRepository;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.infrastructure.service.PostalCodeMapper;
import com.switchfully.sharkmen.parkinglot.ContactPerson;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDTO;
import com.switchfully.sharkmen.parkinglot.domain.ContactPersonRepository;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLot;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingLotService {

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

    public CreateParkingLotResultDTO createParkingLot(CreateParkingLotDTO parkingLotDTO) {
        System.out.println(parkingLotDTO);
        PostalCode parkingLotPostalCode = postalCodeMapper.toPostalCode(parkingLotDTO.getCreateAddressDto().getCreatePostalCodeDto());
        PostalCode contactPersonPostalCode = postalCodeMapper.toPostalCode(parkingLotDTO.getCreateContactPersonDto().getCreateAddressDto().getCreatePostalCodeDto());
        Address parkingLotAddress = addressMapper.toAddress(parkingLotDTO.getCreateAddressDto(), parkingLotPostalCode);
        Address contactPersonAddress = addressMapper.toAddress(parkingLotDTO.getCreateContactPersonDto().getCreateAddressDto(), contactPersonPostalCode);
        ContactPerson contactPerson = contactPersonMapper.toContactPerson(parkingLotDTO.getCreateContactPersonDto(), contactPersonAddress);
        ParkingLot parkingLot = parkingLotMapper.toParkingLot(parkingLotDTO, contactPerson, parkingLotAddress);

        postalCodeRepository.save(parkingLotPostalCode);
        postalCodeRepository.save(contactPersonPostalCode);
        addressRepository.save(parkingLotAddress);
        addressRepository.save(contactPersonAddress);
        contactPersonRepository.save(contactPerson);
        parkingLotRepository.save(parkingLot);

        return parkingLotMapper.toCreateParkingLotResultDto(parkingLot);
    }
}
