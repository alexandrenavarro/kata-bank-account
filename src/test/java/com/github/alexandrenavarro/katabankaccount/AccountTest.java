package com.github.alexandrenavarro.katabankaccount;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>AccountTest. </p>
 *
 * @author anavarro
 *
 */
@RunWith(JUnitParamsRunner.class)
public final class AccountTest {

    /**
     * should_return_statement_balance_100_when_i_deposit_100.
     *
     */
    @Test
    public void should_return_statement_balance_100_when_i_deposit_100() {
        final double aDepositOf100 = 100;
        final Account account = new Account();
        final Account expectedAccount = account.deposit(aDepositOf100);
        assertThat(expectedAccount.getStatement().getBalance()).isEqualTo(aDepositOf100);
        assertThat(expectedAccount).isNotNull();
    }
    
    /**
     * should_return_statement_balance_100_when_i_deposit_100.
     *
     */
    @Test
    public void should_return_statement_balance_100_when_i_deposit_100_today() {
        final double aDepositOf100 = 100;
        final Account account = new Account();
        final Account expectedAccount = account.deposit(aDepositOf100, LocalDateTime.now());
        assertThat(expectedAccount.getStatement().getBalance()).isEqualTo(aDepositOf100);
        assertThat(expectedAccount).isNotNull();
    }

    /**
     * should_return_statement_balance_50_when_i_deposit_100_and_i_withdraw_50.
     *
     */
    @Test
    public void should_return_statement_balance_50_when_i_deposit_100_and_i_withdraw_50() {
        final Account account = new Account();
        final Account expectedAccount = account.deposit(100).withdraw(50);
        assertThat(expectedAccount.getStatement().getBalance()).isEqualTo(50);
        assertThat(expectedAccount).isNotNull();
    }
    
    /**
     * should_return_statement_balance_minus_50_when_i_withdraw_50.
     *
     */
    @Test
    public void should_return_statement_balance_minus_50_when_i_withdraw_50() {
        final Account account = new Account();
        final Account expectedAccount = account.withdraw(50);
        assertThat(expectedAccount.getStatement().getBalance()).isEqualTo(-50);
        assertThat(expectedAccount).isNotNull();
    }
    
    @Test
    public void should_return_statement_balance_minus_50_when_i_withdraw_50_today() {
        final Account account = new Account();
        final Account expectedAccount = account.withdraw(50, LocalDateTime.now());
        assertThat(expectedAccount.getStatement().getBalance()).isEqualTo(-50);
        assertThat(expectedAccount).isNotNull();
    }
    
    /**
     * should_return_statement_items_size_2_and_balance_50_when_i_deposit_100_and_i_withdraw_50.
     *
     */
    @Test
    public void should_return_statement_items_size_2_and_balance_50_when_i_deposit_100_and_i_withdraw_50() {
        final Statement statement = new Account().deposit(100).withdraw(50).getStatement();
        assertThat(statement.getBalance()).isEqualTo(50);
        assertThat(statement.getStatementItems().size()).isEqualTo(2);
    }

    
    /**
     * should_return_statement_balance_$1_when_i_did_transaction_with_amount_$2_$3_$4.
     *
     * @param expectedBalance
     * @param amount1
     * @param amount2
     * @param amount3
     */
    @Test
    @Parameters({"50, 100, -30, -20", 
                 "40, 50, 0, -10",
                 "0, 0, 0, 0",
                 "30, 10, 10, 10"
    
    })
    public void should_return_statement_balance_$1_when_i_did_transaction_with_amount_$2_$3_$4(final double expectedBalance, final double amount1, final double amount2, final double amount3) {
        final Account account = new Account();
        if (amount1 > 0) {
            account.deposit(amount1);
        } else {
            account.withdraw(-amount1);
        }
        if (amount2 > 0) {
            account.deposit(amount2);
        } else {
            account.withdraw(-amount2);
        }
        if (amount3 > 0) {
            account.deposit(amount3);
        } else {
            account.withdraw(-amount3);
        }
        assertThat(account.getStatement().getBalance()).isEqualTo(expectedBalance);
    }
    

}
