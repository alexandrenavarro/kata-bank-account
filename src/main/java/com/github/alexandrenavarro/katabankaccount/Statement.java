package com.github.alexandrenavarro.katabankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * <p>Statement. </p>
 * 
 * Just the statement of the bank account.
 *
 * @author anavarro
 *
 */
// May split 2 classes + (one for have [StatementItem|Transaction]Repository (to externalize the way to store datas) + StatementPrinter (to externalize logic for the print)
public final class Statement {
    
    // Should have another implement without caching balance, just with List<Transaction>
    private final List<StatementItem> statementItems = new ArrayList<>();

    /**
     * getStatementItems.
     *
     * @return
     */
    public List<StatementItem> getStatementItems() {
        return Collections.unmodifiableList(this.statementItems);
    }
    
    
    /**
     * addTransaction.
     *
     * @param transaction
     */
    public void addTransaction(final Transaction transaction) {
        this.statementItems.add(new StatementItem(transaction, this.getBalance() + transaction.getAmount()));
    }
    
    
    /**
     * getBalance.
     *
     * @return
     */
    public double getBalance() {
        return this.statementItems.isEmpty() ? 0 : this.statementItems.get(this.statementItems.size() - 1).getBalance();
        
    } 
    
    /**
     * print.
     *
     * @return
     */
    public String print() {
        // You may use a templating mustache if you want to a very specific 
        final StringBuilder sb = new StringBuilder();
        for (final StatementItem statementItem : this.statementItems) {
            sb.append(statementItem.getTransaction().getDate()).append(" ");
            sb.append(statementItem.getTransaction().getOperation()).append(" ");
            sb.append(statementItem.getTransaction().getAmount()).append(" ");
            sb.append(statementItem.getBalance());
            sb.append("\n");
        }
        return sb.toString();
    }
  

}
