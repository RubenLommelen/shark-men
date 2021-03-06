package com.switchfully.sharkmen.parking_allocation.domain;

import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.parking_lot.domain.ParkingLot;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "parking_allocation")
public class ParkingAllocation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_allocation_seq")
    @SequenceGenerator(name = "parking_allocation_seq", sequenceName = "parking_allocation_seq", allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "fk_member_id")
    private Member member;
    @Column(name = "license_plate_number")
    private String licensePlateNumber;
    @OneToOne
    @JoinColumn(name = "fk_parking_lot_id")
    private ParkingLot parkingLot;
    @Column(name = "start_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime startTime;

    public ParkingAllocation(Member member, String licensePlateNumber, ParkingLot parkingLot) {
        this.member = member;
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLot = parkingLot;
        this.startTime = OffsetDateTime.now();
    }

    public ParkingAllocation() {
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }


    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingAllocation that = (ParkingAllocation) o;
        return Objects.equals(member, that.member) && Objects.equals(licensePlateNumber, that.licensePlateNumber) && Objects.equals(parkingLot, that.parkingLot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, licensePlateNumber, parkingLot);
    }
}
