package com.cory.transactions.services;

import com.cory.transactions.ac.TransactionSystem;
import com.cory.transactions.domain.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    final TransactionSystem transactionSystem;

    @Autowired
    public TransactionServiceImpl(TransactionSystem transactionSystem) {

        this.transactionSystem = transactionSystem;

    }

    /**
     * {@inheritDoc}
     */
    public List<TransactionDto> listAllTransactions() throws IOException {

        return transactionSystem.listAllTransactions();

    }

    /**
     * {@inheritDoc}
     */
    public List<TransactionDto> listTransactionsByType(String transactionType) throws Exception {

        Verify.NotEmpty(transactionType, "transactionType");

        List<TransactionDto> transactionDtoList = listAllTransactions();

        return transactionDtoList.stream()
                        .filter(tx -> tx.getTransactionType().equals(transactionType))
                        .collect(Collectors.toList());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getTotalByTransactionType(String transactionType) throws Exception {

        Verify.NotEmpty(transactionType, "transactionType");

        // Would normally consider using MonetaryAmount and checking currency type consistency.
        // Seems to go beyond the scope of this test.

        List<TransactionDto> transactionDtoList = listTransactionsByType(transactionType);

        return transactionDtoList.stream().mapToDouble(TransactionDto::getTransactionAmount).sum();

    }

}
