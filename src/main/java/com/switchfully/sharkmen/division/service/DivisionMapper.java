package com.switchfully.sharkmen.division.service;

import com.switchfully.sharkmen.division.api.dto.CreateDivisionDto;
import com.switchfully.sharkmen.division.api.dto.DivisionDto;
import com.switchfully.sharkmen.division.domain.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {
    public Division toDivision(CreateDivisionDto createDivisionDto) {
        return new Division(createDivisionDto.getName(), createDivisionDto.getOriginalName(), createDivisionDto.getDirector());
    }

    public DivisionDto toDto(Division divisionToSave) {
        return new DivisionDto(divisionToSave.getId(), divisionToSave.getName(), divisionToSave.getOriginalName(), divisionToSave.getDirector());
    }
}
