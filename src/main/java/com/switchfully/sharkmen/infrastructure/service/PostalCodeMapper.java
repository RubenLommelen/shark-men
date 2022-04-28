package com.switchfully.sharkmen.infrastructure.service;

import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostalCodeMapper {

    private Logger postalCodeMapperLogger = LoggerFactory.getLogger(PostalCodeMapper.class) ;

    public PostalCode toPostalCode (PostalCodeDto postalCodeDto){
        postalCodeMapperLogger.info("PostalCodeDto conversion to PostalCode");
        return new PostalCode(postalCodeDto.getZipcode(), postalCodeDto.getCity());
    }

    public PostalCodeDto toDto (PostalCode postalCode){
        postalCodeMapperLogger.info("PostalCodeDto conversion to PostalCode");
        return new PostalCodeDto(postalCode.getZipcode(), postalCode.getCity());
    }
}
