package com.switchfully.sharkmen.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByLicensePlateLicensePlateNumber(String licensePlateNumber);
}
