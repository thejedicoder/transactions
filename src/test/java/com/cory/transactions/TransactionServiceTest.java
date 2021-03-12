package com.cory.transactions;

import com.cory.transactions.AC.TransactionSystem;
import com.cory.transactions.Domain.TransactionDto;
import com.cory.transactions.Services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {

    @Mock
    TransactionSystem transactionSystem;

    //@InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    public void setup() {
        transactionSystem = mock(TransactionSystem.class);
        transactionService = new TransactionService(transactionSystem);

    }

    @Test
    public void TransactionService_ListAllTransactions_Success() throws IOException {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        List<TransactionDto> resultList = transactionService.ListAllTransactions();

        assertNotNull(resultList);
        assertEquals(3, resultList.size());

        TransactionDto firstDto = dtoList.get(0);
        TransactionDto secondDto = dtoList.get(1);
        TransactionDto thirdDto = dtoList.get(2);

        TransactionDto foundFirst = resultList.stream()
                .filter(tx -> tx.getId().equals(firstDto.getId()))
                .findFirst().orElse(null);

        TransactionDto foundSecond = resultList.stream()
                .filter(tx -> tx.getId().equals(secondDto.getId()))
                .findFirst().orElse(null);

        TransactionDto foundThird = resultList.stream()
                .filter(tx -> tx.getId().equals(thirdDto.getId()))
                .findFirst().orElse(null);

        assertNotNull(foundFirst);
        assertNotNull(foundSecond);
        assertNotNull(foundThird);
    }

    @Test
    public void TransactionService_ListAllTransactions_EmptyReturn() throws IOException {

        List<TransactionDto> dtoList = new ArrayList<>();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        List<TransactionDto> resultList = transactionService.ListAllTransactions();

        assertNotNull(resultList);
        assertEquals(0, resultList.size());
    }

    @Test
    public void TransactionService_ListTransactionsByType_Deposits_Success() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        List<TransactionDto> resultList = transactionService.ListTransactionsByType("Deposit");

        assertNotNull(resultList);
        assertEquals(2, resultList.size());

        TransactionDto firstDto = dtoList.get(0);
        TransactionDto secondDto = dtoList.get(1);
        TransactionDto thirdDto = dtoList.get(2);

        TransactionDto foundFirst = resultList.stream()
                .filter(tx -> tx.getId().equals(firstDto.getId()))
                .findFirst().orElse(null);

        TransactionDto foundSecond = resultList.stream()
                .filter(tx -> tx.getId().equals(secondDto.getId()))
                .findFirst().orElse(null);

        TransactionDto foundThird = resultList.stream()
                .filter(tx -> tx.getId().equals(thirdDto.getId()))
                .findFirst().orElse(null);

        assertNotNull(foundFirst);
        assertNull(foundSecond);
        assertNotNull(foundThird);
    }

    @Test
    public void TransactionService_ListTransactionsByType_EmptyResult() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        List<TransactionDto> resultList = transactionService.ListTransactionsByType("InvalidType");

        assertNotNull(resultList);
        assertEquals(0, resultList.size());

        TransactionDto firstDto = dtoList.get(0);
        TransactionDto secondDto = dtoList.get(1);
        TransactionDto thirdDto = dtoList.get(2);

        TransactionDto foundFirst = resultList.stream()
                .filter(tx -> tx.getId().equals(firstDto.getId()))
                .findFirst().orElse(null);

        TransactionDto foundSecond = resultList.stream()
                .filter(tx -> tx.getId().equals(secondDto.getId()))
                .findFirst().orElse(null);

        TransactionDto foundThird = resultList.stream()
                .filter(tx -> tx.getId().equals(thirdDto.getId()))
                .findFirst().orElse(null);

        assertNull(foundFirst);
        assertNull(foundSecond);
        assertNull(foundThird);
    }

    @Test
    public void TransactionService_ListTransactionsByType_EmptyParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionService.ListTransactionsByType(""));

    }

    @Test
    public void TransactionService_ListTransactionsByType_NullParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionService.ListTransactionsByType(null));

    }

    @Test
    public void TransactionService_GetTotalByTransactionType_Success() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        Double resultTotal = transactionService.GetTotalByTransactionType("Deposit");

        assertNotNull(resultTotal);
        assertEquals(Double.valueOf("4.40"), resultTotal);

    }

    @Test
    public void TransactionService_GetTotalByTransactionType_EmptyParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionService.GetTotalByTransactionType(""));

    }

    @Test
    public void TransactionService_GetTotalByTransactionType_NullParameter() throws Exception {

        List<TransactionDto> dtoList = GenerateTestTransactions();
        when(transactionSystem.ListAllTransactions()).thenReturn(dtoList);

        assertThrows(Exception.class, () -> transactionService.GetTotalByTransactionType(null));

    }

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
