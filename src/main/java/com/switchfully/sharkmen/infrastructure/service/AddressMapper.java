package com.switchfully.sharkmen.infrastructure.service;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final PostalCodeMapper postalCodeMapper;

    public AddressMapper(PostalCodeMapper postalCodeMapper) {
        this.postalCodeMapper = postalCodeMapper;
    }

    public Address toAddress (AddressDto addressDto){
        return new Address(
                addressDto.getStreetName(),
                addressDto.getStreetNumber(),
                postalCodeMapper.toPostalCode(addressDto.getPostalCode())
                );
    }

    public AddressDto toDto (Address address){
        return new AddressDto(
                address.getStreetName(),
                address.getStreetNumber(),
                postalCodeMapper.toDto(address.getPostalCode())
        );
    }
}
