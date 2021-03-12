package com.cory.transactions.Services;

import com.cory.transactions.Domain.TransactionDto;

import java.io.IOException;
import java.util.List;

/**
 * Service that provides Transaction operations
 */
public interface ITransactionService {

    /**
     * Lists all Transactions
     * @return List of TransactionDto
     * @throws IOException when underlying data source is not successful
     */
    List<TransactionDto> ListAllTransactions() throws IOException;

    /**
     * Lists all Transactions of a given Type
     * @param transactionType Required non-empty String containing the Transaction Type
     * @return List of TransactionDto
     * @throws Exception when underlying data source is not successful
     */
    List<TransactionDto> ListTransactionsByType(String transactionType) throws Exception;

    /**
     * Gets the total summed from all Transactions of a given Transaction Type
     * @param transactionType Required non-empty String containing the Transaction Type
     * @return List of TransactionDto
     * @throws Exception when underlying data source is not successful
     */
    Double GetTotalByTransactionType(String transactionType) throws Exception;
}
