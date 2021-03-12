package com.cory.transactions.AC.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionShellDto {

    private List<OpenBankTransactionDto> transactions;

    public List<OpenBankTransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<OpenBankTransactionDto> transactions) {
        this.transactions = transactions;
    }

}
