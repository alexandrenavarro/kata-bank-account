package com.github.alexandrenavarro.katabankaccount;

import java.time.LocalDateTime;


/**
 * <p>Account. </p>
 * Just a representation of the bank account
 *
 * @author anavarro
 *
 */
// You may extract a interface Account and create different type of of Account with different rules on deposit / withdraw if necessary 
public final class Account {

    private final Statement statement = new Statement();
    
    /**
     * deposit.
     *
     * @param aAmount
     * @param aDate
     * @return
     */
    public Account deposit(final double aAmount, final LocalDateTime aDate) {
        this.statement.addTransaction(new Transaction(aAmount, aDate));
        return this; 
    }
    
    
    /**
     * deposit.
     *
     * @param aAmount
     * @return
     */
    public Account deposit(double aAmount) {
        // You may add D+2 for a deposit and check if amount > x
        deposit(aAmount, LocalDateTime.now());
        return this;
    }
    
    
    /**
     * withdraw.
     *
     * @param aAmount
     * @param aDate
     * @return
     */
    public Account withdraw(double aAmount, LocalDateTime aDate) {
        // You may check if the balance > 0
        this.statement.addTransaction(new Transaction(-aAmount, aDate));
        return this;
    }
    
    /**
     * withdraw.
     *
     * @param aAmount
     * @return
     */
    public Account withdraw(double aAmount) {
        withdraw(aAmount, LocalDateTime.now());
        return this;
    }

    
    /**
     * getStatement.
     *
     * @return
     */
    public Statement getStatement() {
        return this.statement;
    }

    
}
