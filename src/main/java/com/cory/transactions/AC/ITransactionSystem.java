package com.cory.transactions.AC;

import com.cory.transactions.AC.contracts.OpenBankTransactionDto;
import com.cory.transactions.Domain.TransactionDto;

import java.io.IOException;
import java.util.List;

public interface ITransactionSystem {

    List<TransactionDto> ListAllTransactions() throws IOException;

    List<TransactionDto> ListTransactionsByType(String transactionType) throws IOException;

    Double GetTotalByTransactionType(String transactionType) throws IOException;
}
