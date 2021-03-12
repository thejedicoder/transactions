package com.cory.transactions;

import com.cory.transactions.AC.contracts.*;
import com.cory.transactions.Domain.TransactionDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OpenBankTransactionTransformTest {

    @Test
    public void OpenBankTransactionDto_ToTransactionDto_Success() {

        OpenBankTransactionDto dto = GenerateTestDto();

        TransactionDto resultDto = dto.ToTransactionDto();

        assertNotNull(resultDto);
        assertEquals(dto.getId(), resultDto.getId());
        assertEquals(dto.getThis_account().getId(), resultDto.getAccountId());
        assertEquals(dto.getOther_account().getNumber(), resultDto.getCounterpartyAccount());
        assertEquals(dto.getOther_account().getHolder().getName(), resultDto.getCounterpartyName());
        assertEquals(dto.getOther_account().getMetadata().getImage_URL(), resultDto.getCounterpartyLogoPath());
        assertEquals(dto.getDetails().getType(), resultDto.getTransactionType());
        assertEquals(dto.getDetails().getDescription(), resultDto.getDescription());
        assertEquals(dto.getDetails().getValue().getAmount(), resultDto.getInstructedAmount());
        assertEquals(dto.getDetails().getValue().getCurrency(), resultDto.getInstructedCurrency());
        assertEquals(dto.getDetails().getValue().getAmount(), resultDto.getTransactionAmount());
        assertEquals(dto.getDetails().getValue().getCurrency(), resultDto.getTransactionCurrency());

    }

    private OpenBankTransactionDto GenerateTestDto() {

        OpenBankTransactionDto dto = new OpenBankTransactionDto();
        dto.setId("111");
        OpenBankTransactionDetailsDto detailsDto = new OpenBankTransactionDetailsDto();
        detailsDto.setDescription("descrip 1");
        detailsDto.setType("type 1");
        OpenBankTransactionDetailsValueDto valueDto = new OpenBankTransactionDetailsValueDto();
        valueDto.setAmount(1.1);
        valueDto.setCurrency("USD");
        detailsDto.setValue(valueDto);
        dto.setDetails(detailsDto);
        OpenBankTransactionAccountDto thisAccountDto = new OpenBankTransactionAccountDto();
        thisAccountDto.setId("555");
        dto.setThis_account(thisAccountDto);
        OpenBankTransactionAccountDto otherAccountDto = new OpenBankTransactionAccountDto();
        otherAccountDto.setId("777");
        otherAccountDto.setNumber("Number 777");
        OpenBankTransactionAccountHolderDto holderDto = new OpenBankTransactionAccountHolderDto();
        holderDto.setName("Holder name 777");
        otherAccountDto.setHolder(holderDto);
        OpenBankTransactionAccountMetadataDto metadataDto = new OpenBankTransactionAccountMetadataDto();
        metadataDto.setImage_URL("http://testing.com");
        otherAccountDto.setMetadata(metadataDto);
        dto.setOther_account(otherAccountDto);

        return dto;
    }
}
