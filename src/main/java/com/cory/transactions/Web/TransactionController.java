package com.cory.transactions.Web;

import com.cory.transactions.AC.ITransactionSystem;
import com.cory.transactions.AC.contracts.OpenBankTransactionDto;
import com.cory.transactions.Domain.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    final ITransactionSystem transactionSystem;
    private static final Logger logger = Logger.getLogger(TransactionController.class.getName());

    @Autowired
    public TransactionController(ITransactionSystem transactionSystem) {

        this.transactionSystem = transactionSystem;

    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> ListAllTransactions() throws IOException {

        return transactionSystem.ListAllTransactions();

    }

    @GetMapping(value = "/type/{transactionType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> ListTransactionsByType(@PathVariable String transactionType) throws IOException {

        return transactionSystem.ListTransactionsByType(transactionType);

    }

    @GetMapping(value = "/type/{transactionType}/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double GetTotalByTransactionType(@PathVariable String transactionType) throws IOException {

        return transactionSystem.GetTotalByTransactionType(transactionType);

    }

}
