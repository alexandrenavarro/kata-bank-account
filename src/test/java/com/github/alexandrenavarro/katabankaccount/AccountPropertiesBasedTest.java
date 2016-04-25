package com.github.alexandrenavarro.katabankaccount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * <p>AccountPropertiesBasedTest. </p>
 *
 * @author anavarro - Apr 25, 2016
 *
 */
@RunWith(JUnitQuickcheck.class)
public final class AccountPropertiesBasedTest {

    /**
     * should_return_statement_balance_positive_when_i_deposit.
     *
     * @param amount
     */
    @Property
    public void should_return_statement_balance_positive_when_i_deposit(final double amount) {
        final Account account = new Account();
        account.deposit(Math.abs(amount));
        assertThat(account.getStatement().getBalance()).isGreaterThanOrEqualTo(0);

    }

    /**
     * should_return_statement_balance_positive_when_i_withdraw.
     *
     * @param amount
     */
    @Property
    public void should_return_statement_balance_positive_when_i_withdraw(final double amount) {
        final Account account = new Account();
        account.withdraw(Math.abs(amount));
        assertThat(account.getStatement().getBalance()).isLessThanOrEqualTo(0);

    }

}
