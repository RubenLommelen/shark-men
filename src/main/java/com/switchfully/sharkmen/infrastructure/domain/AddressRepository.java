package com.switchfully.sharkmen.infrastructure.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
