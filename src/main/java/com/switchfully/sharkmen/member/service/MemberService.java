package com.switchfully.sharkmen.member.service;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
public class MemberService {


    public MemberDto registerMember(@RequestBody CreateMemberDto createMemberDto) {
        return new MemberDto(1512L,"Harry Potter",
                new Address(15121,"Privet drive", "4", new PostalCode(1515,"WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwarts.uk", "7990TD", LocalDate.now());
    }
}
