package com.cory.transactions.web;

import com.cory.transactions.domain.TransactionDto;
import com.cory.transactions.services.TransactionService;
import com.cory.transactions.services.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * API controller providing REST methods for Transaction data
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    final TransactionService transactionService;
    private static final Logger logger = Logger.getLogger(TransactionController.class.getName());

    /**
     * Constructor
     * @param transactionService Required ITransactionService
     */
    @Autowired
    public TransactionController(TransactionService transactionService) {

        this.transactionService = transactionService;

    }

    /**
     * Provides a list of all Transactions
     * @return List of TransactionDto
     * @throws IOException when underlying service is not successful
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> listAllTransactions() throws IOException {

        return transactionService.listAllTransactions();

    }

    /**
     * Provides a list of all Transactions of a given Transaction Type
     * @param transactionType Required non-empty String containing the Transaction Type
     * @return List of TransactionDto
     * @throws Exception when underlying service is not successful
     */
    @GetMapping(value = "/type/{transactionType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> listTransactionsByType(@PathVariable String transactionType) throws Exception {

        Verify.NotEmpty(transactionType, "transactionType");

        return transactionService.listTransactionsByType(transactionType);

    }

    /**
     * Provides the amount totalled from the Transactions of a given Transaction Type
     * @param transactionType Required non-empty String containing the Transaction Type
     * @return List of TransactionDto
     * @throws Exception when underlying service is not successful
     */
    @GetMapping(value = "/type/{transactionType}/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double getTotalByTransactionType(@PathVariable String transactionType) throws Exception {

        Verify.NotEmpty(transactionType, "transactionType");

        return transactionService.getTotalByTransactionType(transactionType);

    }

}
