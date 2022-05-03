package com.switchfully.sharkmen.division.service;

import com.switchfully.sharkmen.division.api.dto.CreateDivisionDto;
import com.switchfully.sharkmen.division.api.dto.DivisionDto;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    public DivisionDto createDivision( CreateDivisionDto createDivisionDto){
        return new DivisionDto("Hogwarts", "The four wizards school", "Hagrid");
    }
}
