package com.cory.transactions.Services;

import com.cory.transactions.Domain.TransactionDto;

import java.io.IOException;
import java.util.List;

public interface ITransactionService {

    List<TransactionDto> ListAllTransactions() throws IOException;

    List<TransactionDto> ListTransactionsByType(String transactionType) throws Exception;

    Double GetTotalByTransactionType(String transactionType) throws Exception;
}
