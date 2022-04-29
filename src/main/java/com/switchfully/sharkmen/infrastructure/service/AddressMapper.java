package com.switchfully.sharkmen.infrastructure.service;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.infrastructure.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final Logger addressMapperLogger = LoggerFactory.getLogger(AddressMapper.class);

    private final PostalCodeMapper postalCodeMapper;

    public AddressMapper(PostalCodeMapper postalCodeMapper) {
        this.postalCodeMapper = postalCodeMapper;
    }

    public Address toAddress(AddressDto addressDto) {
        addressMapperLogger.info("AddressDto conversion to Address");
        return new Address(
                addressDto.getStreetName(),
                addressDto.getStreetNumber(),
                postalCodeMapper.toPostalCode(addressDto.getPostalCodeDto())
        );
    }

    public Address toAddress(CreateAddressDto createAddressDto) {
        addressMapperLogger.info("AddressDto conversion to Address");
        return new Address(
                createAddressDto.getStreetName(),
                createAddressDto.getStreetNumber(),
                postalCodeMapper.toPostalCode(createAddressDto.getCreatePostalCodeDto())
        );
    }

    public AddressDto toDto(Address address) {
        addressMapperLogger.info("Address conversion to AddressDto");
        return new AddressDto(
                address.getStreetName(),
                address.getStreetNumber(),
                postalCodeMapper.toDto(address.getPostalCode())
        );
    }
}
