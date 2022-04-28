package com.switchfully.sharkmen.member.api;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.Member;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "members")
public class MemberController {

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public MemberDto registerMember(@RequestBody CreateMemberDto createMemberDto) {
        return new MemberDto("jhbhb","Harry Potter",
                new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwarts.uk", "7990TD", LocalDate.now());
    }
}
