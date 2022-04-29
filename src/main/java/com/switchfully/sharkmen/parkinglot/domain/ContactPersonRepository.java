package com.switchfully.sharkmen.parkinglot.domain;

import com.switchfully.sharkmen.parkinglot.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {
}
