package com.switchfully.sharkmen.infrastructure.service;

import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import org.springframework.stereotype.Component;

@Component
public class PostalCodeMapper {

    public PostalCode toPostalCode (PostalCodeDto postalCodeDto){
        return new PostalCode(postalCodeDto.getZipcode(), postalCodeDto.getCity());
    }

    public PostalCodeDto toDto (PostalCode postalCode){
        return new PostalCodeDto(postalCode.getZipcode(), postalCode.getCity());
    }
}
