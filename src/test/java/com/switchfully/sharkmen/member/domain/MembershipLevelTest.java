package com.switchfully.sharkmen.member.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MembershipLevelTest {

    @Test
    void createMembershipLevelBronze_thenFieldsCorrect() {
        MembershipLevel membershipLevel = MembershipLevel.BRONZE;

        Assertions.assertThat(membershipLevel.getMonthlyCost()).isEqualTo(0);
        Assertions.assertThat(membershipLevel.getReduction()).isEqualTo(0);
        Assertions.assertThat(membershipLevel.getMaxAllocationTime()).isEqualTo(4);
    }

    @Test
    void createMembershipLevelSilver_thenFieldsCorrect() {
        MembershipLevel membershipLevel = MembershipLevel.SILVER;

        Assertions.assertThat(membershipLevel.getMonthlyCost()).isEqualTo(10);
        Assertions.assertThat(membershipLevel.getReduction()).isEqualTo(20);
        Assertions.assertThat(membershipLevel.getMaxAllocationTime()).isEqualTo(6);
    }

    @Test
    void createMembershipLevelGold_thenFieldsCorrect() {
        MembershipLevel membershipLevel = MembershipLevel.GOLD;

        Assertions.assertThat(membershipLevel.getMonthlyCost()).isEqualTo(40);
        Assertions.assertThat(membershipLevel.getReduction()).isEqualTo(30);
        Assertions.assertThat(membershipLevel.getMaxAllocationTime()).isEqualTo(24);
    }
}