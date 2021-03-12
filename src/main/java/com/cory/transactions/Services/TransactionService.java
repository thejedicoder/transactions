package com.cory.transactions.Services;

import com.cory.transactions.AC.ITransactionSystem;
import com.cory.transactions.Domain.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService implements ITransactionService {

    final ITransactionSystem transactionSystem;

    @Autowired
    public TransactionService(ITransactionSystem transactionSystem) {

        this.transactionSystem = transactionSystem;

    }


    public List<TransactionDto> ListAllTransactions() throws IOException {

        return transactionSystem.ListAllTransactions();

    }

    public List<TransactionDto> ListTransactionsByType(String transactionType) throws Exception {

        Verify.NotEmpty(transactionType, "transactionType");

        List<TransactionDto> transactionDtoList = ListAllTransactions();

        return transactionDtoList.stream()
                        .filter(tx -> tx.getTransactionType().equals(transactionType))
                        .collect(Collectors.toList());

    }

    @Override
    public Double GetTotalByTransactionType(String transactionType) throws Exception {

        Verify.NotEmpty(transactionType, "transactionType");

        // Would normally consider using MonetaryAmount and checking currency type consistency.
        // Seems to go beyond the scope of this test.

        List<TransactionDto> transactionDtoList = ListTransactionsByType(transactionType);

        return transactionDtoList.stream().mapToDouble(TransactionDto::getTransactionAmount).sum();

    }

}
