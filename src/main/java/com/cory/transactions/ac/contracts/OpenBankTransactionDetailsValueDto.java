package com.cory.transactions.ac.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the Value on an OpenBank Transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionDetailsValueDto {

    private double amount;
    private String currency;

    /**
     * Gets the Amount
     * @return double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the Amount
     * @param amount double to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the Currency
     * @return String
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the Currency
     * @param currency String to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
