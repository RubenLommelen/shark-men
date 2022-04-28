package com.switchfully.sharkmen.member.service;

import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberDto registerMember(CreateMemberDto createMemberDto) {
        Member memberToRegister = memberMapper.ToMember(createMemberDto);
        return memberMapper.ToDto(memberToRegister);
    }
}
