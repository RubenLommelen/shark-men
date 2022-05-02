package com.switchfully.sharkmen.member.domain;

public enum MembershipLevel {
    BRONZE(0, 0, 4),
    SILVER(10, 20, 6),
    GOLD(40, 30, 24);

    private final double monthlyCost;
    private final double reduction;
    private final int maxAllocationTime;

    MembershipLevel(double monthlyCost, double reduction, int maxAllocationTime) {
        this.monthlyCost = monthlyCost;
        this.reduction = reduction;
        this.maxAllocationTime = maxAllocationTime;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getReduction() {
        return reduction;
    }

    public int getMaxAllocationTime() {
        return maxAllocationTime;
    }
}
