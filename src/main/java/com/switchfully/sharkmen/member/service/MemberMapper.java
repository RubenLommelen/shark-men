package com.switchfully.sharkmen.member.service;


import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import com.switchfully.sharkmen.member.license_plate.service.LicensePlateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    private final Logger memberMapperLogger = LoggerFactory.getLogger(MemberMapper.class);

    private final AddressMapper addressMapper;
    private final LicensePlateMapper licensePlateMapper;
    private final MemberRepository memberRepository;

    public MemberMapper(AddressMapper addressMapper, LicensePlateMapper licensePlateMapper, MemberRepository memberRepository) {
        this.addressMapper = addressMapper;
        this.licensePlateMapper = licensePlateMapper;
        this.memberRepository = memberRepository;
    }

    public MemberDto ToDto(Member member) {
        memberMapperLogger.info("Member conversion to MemberDto");
        return new MemberDto(
                member.getMemberId(),
                member.getFirstName(),
                member.getLastName(),
                addressMapper.toDto(member.getAddress()),
                member.getPhoneNumber(),
                member.getEmailAddress(),
                licensePlateMapper.toDto(member.getLicensePlate()),
                member.getRegistrationDate());
    }

    public Member ToMember(CreateMemberDto createMemberDto) {
        memberMapperLogger.info("CreateMemberDto conversion to Member");
        return new Member(
                createMemberDto.getFirstName(),
                createMemberDto.getLastName(),
                addressMapper.toAddress(createMemberDto.getAddress()),
                createMemberDto.getPhoneNumber(),
                createMemberDto.getEmailAddress(),
                licensePlateMapper.toLicensePlate(createMemberDto.getLicensePlate()));

    }

    public Member toMember(Long memberId) {
        return memberRepository.getById(memberId);

    }
}
