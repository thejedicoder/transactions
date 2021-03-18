package com.cory.transactions.ac.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents the overall data response from the Transaction data source at OpenBank
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionShellDto {

    private List<OpenBankTransactionDto> transactions;

    /**
     * Gets the List of Transactions
     * @return List of OpenBankTransactionDto
     */
    public List<OpenBankTransactionDto> getTransactions() {
        return transactions;
    }

    /**
     * Sets the List of Transactions
     * @param transactions List of OpenOpenBankTransactionDto to set
     */
    public void setTransactions(List<OpenBankTransactionDto> transactions) {
        this.transactions = transactions;
    }

}
