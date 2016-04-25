package com.github.alexandrenavarro.katabankaccount;

import java.time.LocalDateTime;

/**
 * <p>Transaction. </p>
 * 
 * Just an operation / transaction done by a client.
 *
 * @author anavarro
 *
 */
public final class Transaction {
    
    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAWAL = "WITHDRAWAL";
    
    // Caution, you may create a Amount if you need to manage different currency and may use BigDecimal to avoid some round precision problem, by defaut is in euros 
    private final double amount;
    private final LocalDateTime date;
    private final String operation;
    
    
    
    /**
     * Constructor.
     *
     * @param aAmount
     * @param aDate
     */
    public Transaction(final double aAmount, final LocalDateTime aDate) {
        super();
        this.amount = aAmount;
        this.date = aDate;
        this.operation = (aAmount >= 0) ? DEPOSIT : WITHDRAWAL;
    }

    /**
     * getAmount.
     *
     * @return
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * getDate.
     *
     * @return
     */
    public LocalDateTime getDate() {
        return this.date;
    }
    
    /**
     * getOperation.
     *
     * @return
     */
    public String getOperation() {
        return this.operation;
    }

}
