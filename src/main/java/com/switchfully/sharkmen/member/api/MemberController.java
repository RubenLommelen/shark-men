package com.switchfully.sharkmen.member.api;

import com.switchfully.sharkmen.member.domain.Member;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "members")
public class MemberController {

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public String registerMember(@RequestBody Member createMemberDto) {
        return "fail";
    }
}
