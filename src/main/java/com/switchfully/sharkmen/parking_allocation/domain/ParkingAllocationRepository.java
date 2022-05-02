package com.switchfully.sharkmen.parking_allocation.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface ParkingAllocationRepository extends JpaRepository<ParkingAllocation,Long>{



}
