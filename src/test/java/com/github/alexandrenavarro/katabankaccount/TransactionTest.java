package com.github.alexandrenavarro.katabankaccount;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * <p>TransactionTest. </p>
 *
 * @author anavarro
 *
 */

public final class TransactionTest {



    /**
     * should_return_transaction_amount_equals_1_and_date_now_and_operation_deposit_when_transaction_amount_equals_1_and_date_now.
     *
     */
    @Test
    public void should_return_transaction_amount_equals_1_and_date_now_and_operation_deposit_when_transaction_amount_equals_1_and_date_now() {
        final double amount = 1.0;
        final LocalDateTime date = LocalDateTime.now();
        final Transaction transaction = new Transaction(amount, date);
        assertThat(transaction.getAmount()).isEqualTo(amount);
        assertThat(transaction.getDate()).isEqualTo(date);
        assertThat(transaction.getOperation()).isEqualTo(Transaction.DEPOSIT);
        assertThat(transaction.getOperation()).isNotEqualTo(Transaction.WITHDRAWAL);
    }
    
    
    /**
     * should_return_transaction_amount_equals_minus_1_and_date_now_and_operation_withdrawal_when_transaction_amount_equals_minus_1_and_date_now.
     *
     */
    @Test
    public void should_return_transaction_amount_equals_minus_1_and_date_now_and_operation_withdrawal_when_transaction_amount_equals_minus_1_and_date_now() {
        final double amount = -1.0;
        final LocalDateTime date = LocalDateTime.now();
        final Transaction transaction = new Transaction(amount, date);
        assertThat(transaction.getAmount()).isEqualTo(amount);
        assertThat(transaction.getDate()).isEqualTo(date);
        assertThat(transaction.getOperation()).isEqualTo(Transaction.WITHDRAWAL);
        assertThat(transaction.getOperation()).isNotEqualTo(Transaction.DEPOSIT);
    }
    
    
    /**
     * should_return_transaction_amount_equals_0_and_date_now_and_operation_deposit_when_transaction_amount_equals_0_and_date_now.
     *
     */
    @Test
    public void should_return_transaction_amount_equals_0_and_date_now_and_operation_deposit_when_transaction_amount_equals_0_and_date_now() {
        final double amount = 0.0;
        final LocalDateTime date = LocalDateTime.now();
        final Transaction transaction = new Transaction(amount, date);
        assertThat(transaction.getAmount()).isEqualTo(amount);
        assertThat(transaction.getDate()).isEqualTo(date);
        assertThat(transaction.getOperation()).isEqualTo(Transaction.DEPOSIT);
        assertThat(transaction.getOperation()).isNotEqualTo(Transaction.WITHDRAWAL);
    }
    
}
