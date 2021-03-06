package com.switchfully.sharkmen.member.service;

import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final Logger memberServiceLogger = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDto registerMember(CreateMemberDto createMemberDto) {
        Member memberToRegister = memberMapper.ToMember(createMemberDto);
        memberServiceLogger.info("Saving member to database");
        memberRepository.save(memberToRegister);
        memberServiceLogger.info("Member " + memberToRegister.getFirstName() + " " + memberToRegister.getLastName() + " has been saved");
        return memberMapper.ToDto(memberToRegister);
    }


}
