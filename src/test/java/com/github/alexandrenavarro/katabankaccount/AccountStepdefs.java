package com.github.alexandrenavarro.katabankaccount;

import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * <p>AccountStepdefs. </p>
 *
 * @author anavarro
 *
 */
public final class AccountStepdefs {

    private Account account = new Account();
    private Statement statement;
    
    /**
     * i_deposit.
     *
     * @param deposit
     */
    @Given("^I deposit (\\d+) euros$")
    public void i_deposit(double deposit) {
        account.deposit(deposit);
    }
    
    /**
     * i_withdraw.
     *
     * @param deposit
     */
    @Given("^I withdraw (\\d+) euros$")
    public void i_withdraw(double deposit) {
        account.withdraw(deposit);
    }
    
    /**
     * i_ask_the_statement.
     *
     */
    @When("^I ask the statement$")
    public void i_ask_the_statement() {
        statement = account.getStatement();
    }
    
    /**
     * my_balance_should_be.
     *
     * @param expectedBalance
     */
    @Then("^My balance should be (-?\\d+)")
    public void my_balance_should_be(double expectedBalance) {
        assertThat(statement.getBalance()).isEqualTo(expectedBalance);
    }
    
}
