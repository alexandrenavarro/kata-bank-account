# kata-bank-account

Bank account kata

Think of your personal bank account experience When in doubt, go for the simplest solution

 

## Requirements

Deposit and Withdrawal

Account statement (date, amount, balance)

Statement printing

 

## User Stories

### US 1:

In order to save money

As a bank client

I want to make a deposit in my account

 

### US 2:

In order to retrieve some or all of my savings

As a bank client

I want to make a withdrawal from my account

 

### US 3:

In order to check my operations

As a bank client

I want to see the history (operation, date, amount, balance)  of my operations



### How to build the project with different testing/quality tools

mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.pitest:pitest-maven:mutationCoverage sonar:sonar
