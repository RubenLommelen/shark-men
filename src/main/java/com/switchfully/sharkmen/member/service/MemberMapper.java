package com.switchfully.sharkmen.member.service;


import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    MemberDto ToDto(Member member) {
        return new MemberDto(member.getMemberId(), member.getFirstName(), member.getAddress(), member.getPhoneNumber(), member.getEmailAddress(), member.getLicensePlate(), member.getRegistrationDate());
    }

    Member ToMember(CreateMemberDto createMemberDto){
        return new Member(createMemberDto.getFirstName(), createMemberDto.getLastName(), createMemberDto.getAddress(), createMemberDto.getPhoneNumber(), createMemberDto.getEmailAddress(), createMemberDto.getLicensePlate());

    }

}
