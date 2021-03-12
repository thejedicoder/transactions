package com.cory.transactions.AC;

import com.cory.transactions.Domain.TransactionDto;

import java.io.IOException;
import java.util.List;

/**
 * Provides methods to fetch Transaction data from an external source.
 */
public interface ITransactionSystem {

    /**
     * Lists all transactions for the external system
     * @return Non-null List of TransactionDto
     * @throws IOException when underlying data source throws exception
     */
    List<TransactionDto> ListAllTransactions() throws IOException;

}
