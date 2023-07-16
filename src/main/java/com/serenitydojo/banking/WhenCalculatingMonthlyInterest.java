package com.serenitydojo.banking;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WhenCalculatingMonthlyInterest {

    @Test
    public void shouldCalculateInterestForSavingsAccounts() {

        // GIVEN
        SavingsAccount savingsAccount = new SavingsAccount(1200.0, 0.01);
        savingsAccount.setBalance(1200);
        savingsAccount.setInterestRate(0.01);

        // WHEN
        double earnedInterest = savingsAccount.calculateMonthlyInterest();

        // THEN
        assertThat(earnedInterest).isEqualTo(1.0);
    }

    @Test
    public void shouldCalculateInterestForBonds() {

        // GIVEN
        InterestYieldingBonds interestYieldingBonds = new InterestYieldingBonds(1200.0,  0.01);

        // WHEN
        double earnedInterest = interestYieldingBonds.calculateMonthlyInterest();

        // THEN
        assertThat(earnedInterest).isEqualTo(1.0);
    }

    @Test
    public void calculateInterestEarnedInPortfolio() {
        // GIVEN
        Portfolio portfolio = new Portfolio();
        portfolio.add(new SavingsAccount(1200.0, 0.01));
        portfolio.add(new InterestYieldingBonds(1200.0, 0.01));

        // WHEN
        double totalEarnedInterest = portfolio.calculateMonthlyInterest();

        // THEN
        assertThat(totalEarnedInterest).isEqualTo(2.0);

    }
}
