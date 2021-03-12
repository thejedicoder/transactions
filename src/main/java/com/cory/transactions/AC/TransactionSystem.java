package com.cory.transactions.AC;

import com.cory.transactions.AC.contracts.OpenBankTransactionDto;
import com.cory.transactions.AC.contracts.OpenBankTransactionShellDto;
import com.cory.transactions.Domain.TransactionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class TransactionSystem implements ITransactionSystem {

    /**
     * {@inheritDoc}
     */
    public List<TransactionDto> ListAllTransactions() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try (CloseableHttpClient httpClient = HttpClients.createDefault())  {

            String transactionUrl =
                    "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";
            HttpGet request = new HttpGet(transactionUrl);

            OpenBankTransactionShellDto transactionDto =
                    httpClient.execute(request,
                            httpResponse -> mapper.readValue(httpResponse.getEntity().getContent(),
                                    OpenBankTransactionShellDto.class));

            List<OpenBankTransactionDto> openBankTransactionDtos = transactionDto.getTransactions();

            return openBankTransactionDtos.stream()
                    .map(OpenBankTransactionDto::ToTransactionDto)
                    .collect(Collectors.toList());
        }

    }

}
