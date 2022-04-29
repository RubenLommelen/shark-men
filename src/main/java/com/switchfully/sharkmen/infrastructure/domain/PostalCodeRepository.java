package com.switchfully.sharkmen.infrastructure.domain;

import com.switchfully.sharkmen.infrastructure.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCode, Long> {
}
