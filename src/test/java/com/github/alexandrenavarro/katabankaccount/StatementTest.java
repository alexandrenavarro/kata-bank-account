package com.github.alexandrenavarro.katabankaccount;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * <p>StatementTest. </p>
 *
 * @author anavarro
 *
 */
public final class StatementTest {


    /**
     * should_print_statement_with_2_items_with_balance_50_when_a_transaction_of_100_and_a_transaction_of_minus_50.
     *
     */
    @Test
    public void should_print_statement_with_2_items_with_balance_50_when_a_transaction_of_100_and_a_transaction_of_minus_50() {
        final Statement statement = new Statement();
        statement.addTransaction(new Transaction(100, LocalDateTime.parse("2000-01-01T00:00:00.000")));
        statement.addTransaction(new Transaction(-50, LocalDateTime.parse("2000-01-02T00:00:00.000")));
        assertThat(statement.getStatementItems().size()).isEqualTo(2);
        assertThat(statement.getBalance()).isEqualTo(50);
        assertThat(statement.print()).isEqualTo("2000-01-01T00:00 DEPOSIT 100.0 100.0\n2000-01-02T00:00 WITHDRAWAL -50.0 50.0\n");
    }

}
