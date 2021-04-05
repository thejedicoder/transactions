package com.cory.transactions;

import com.cory.transactions.domain.TransactionDto;
import com.cory.transactions.services.TransactionServiceImpl;
import com.cory.transactions.web.TransactionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test class for the TransactionController
 */
public class TransactionControllerTest {

    @Mock
    TransactionServiceImpl transactionService;

    private TransactionController transactionController;

    @BeforeEach
    public void setup() {

        transactionService = mock(TransactionServiceImpl.class);
        transactionController = new TransactionController(transactionService);

    }

    @Test
    public void TransactionController_ListAllTransactions_Success() throws IOException {
        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        List<TransactionDto> resultList = transactionController.listAllTransactions();

        assertNotNull(resultList);
        assertEquals(3, resultList.size());
    }

    @Test
    public void TransactionController_ListTransactionsByType_Success() throws Exception {
        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        List<TransactionDto> resultList = transactionController.listTransactionsByType("Deposit");

        assertNotNull(resultList);
        Mockito.verify(transactionService, times(1)).listTransactionsByType(anyString());

    }


    @Test
    public void TransactionController_ListTransactionsByType_EmptyParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionController.listTransactionsByType(""));

    }


    @Test
    public void TransactionController_ListTransactionsByType_NullParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionController.listTransactionsByType(null));

    }


    @Test
    public void TransactionController_GetTotalByTransactionType_Success() throws Exception {
        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        Double total = transactionController.getTotalByTransactionType("Deposit");

        assertNotNull(total);
        Mockito.verify(transactionService, times(1)).getTotalByTransactionType(anyString());

    }


    @Test
    public void TransactionController_GetTotalByTransactionType_EmptyParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionController.getTotalByTransactionType(""));

    }


    @Test
    public void TransactionController_GetTotalByTransactionType_NullParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionService.listAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionController.getTotalByTransactionType(null));

    }

    /**
     * Creates DTO data for unit testing purposes.
     * @return Non-null List of TransactionDto
     */
    private List<TransactionDto> GenerateTestTransactions() {

        List<TransactionDto> dtoList = new ArrayList<>();

        TransactionDto dto1 = new TransactionDto();
        dto1.setId("111");
        dto1.setTransactionType("Deposit");
        dto1.setTransactionAmount(Double.valueOf("1.10"));
        dtoList.add(dto1);

        TransactionDto dto2 = new TransactionDto();
        dto2.setId("222");
        dto2.setTransactionType("Withdrawal");
        dto2.setTransactionAmount(Double.valueOf("2.20"));
        dtoList.add(dto2);

        TransactionDto dto3 = new TransactionDto();
        dto3.setId("333");
        dto3.setTransactionType("Deposit");
        dto3.setTransactionAmount(Double.valueOf("3.30"));
        dtoList.add(dto3);

        return dtoList;
    }
}
