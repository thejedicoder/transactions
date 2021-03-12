package com.cory.transactions.AC.contracts;

import com.cory.transactions.Domain.TransactionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionDto {

    private String id;
    private OpenBankTransactionDetailsDto details;
    private OpenBankTransactionAccountDto this_account;
    private OpenBankTransactionAccountDto other_account;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OpenBankTransactionDetailsDto getDetails() {
        return details;
    }

    public void setDetails(OpenBankTransactionDetailsDto details) {
        this.details = details;
    }

    public OpenBankTransactionAccountDto getThis_account() {
        return this_account;
    }

    public void setThis_account(OpenBankTransactionAccountDto this_account) {
        this.this_account = this_account;
    }

    public OpenBankTransactionAccountDto getOther_account() {
        return other_account;
    }

    public void setOther_account(OpenBankTransactionAccountDto other_account) {
        this.other_account = other_account;
    }


    public TransactionDto ToTransactionDto() {

        TransactionDto newDto = new TransactionDto();

        newDto.setId(id);
        if (this_account != null) {
            newDto.setAccountId(this_account.getId());
        }

        if (other_account != null) {
            newDto.setCounterpartyAccount(other_account.getNumber());
            if (other_account.getHolder() != null) {
                newDto.setCounterpartyName(other_account.getHolder().getName());
            }
            if (other_account.getMetadata() != null) {
                newDto.setCounterpartyLogoPath(other_account.getMetadata().getImage_URL());
            }
        }

        if (details != null) {
            newDto.setTransactionType(details.getType());
            newDto.setDescription(details.getDescription());
            if (details.getValue() != null) {
                newDto.setInstructedAmount(details.getValue().getAmount());
                newDto.setInstructedCurrency(details.getValue().getCurrency());
                newDto.setTransactionAmount(details.getValue().getAmount());
                newDto.setTransactionCurrency(details.getValue().getCurrency());
            }
        }

        return newDto;

    }
}
