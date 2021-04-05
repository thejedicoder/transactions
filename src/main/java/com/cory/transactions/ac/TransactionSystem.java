package com.cory.transactions.ac;

import com.cory.transactions.domain.TransactionDto;

import java.io.IOException;
import java.util.List;

/**
 * Provides methods to fetch Transaction data from an external source.
 */
public interface TransactionSystem {

    /**
     * Lists all transactions for the external system
     * @return Non-null List of TransactionDto
     * @throws IOException when underlying data source throws exception
     */
    List<TransactionDto> listAllTransactions() throws IOException;

}
