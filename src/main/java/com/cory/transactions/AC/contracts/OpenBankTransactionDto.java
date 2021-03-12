package com.cory.transactions.AC.contracts;

import com.cory.transactions.Domain.TransactionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a Transaction in the OpenBank data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionDto {

    private String id;
    private OpenBankTransactionDetailsDto details;
    private OpenBankTransactionAccountDto this_account;
    private OpenBankTransactionAccountDto other_account;

    /**
     * Gets the Id
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Id
     * @param id String to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the Details
     * @return OpenBankTransactionDetailsDto
     */
    public OpenBankTransactionDetailsDto getDetails() {
        return details;
    }

    /**
     * Sets the Details
     * @param details OpenBankTransactionDetailsDto to set
     */
    public void setDetails(OpenBankTransactionDetailsDto details) {
        this.details = details;
    }

    /**
     * Gets the Account known as This Account
     * @return OpenBankTransactionAccountDto
     */
    public OpenBankTransactionAccountDto getThis_account() {
        return this_account;
    }

    /**
     * Sets the Account known as This Account
     * @param this_account OpenBankTransactionAccountDto to set
     */
    public void setThis_account(OpenBankTransactionAccountDto this_account) {
        this.this_account = this_account;
    }

    /**
     * Gets the Account known as Other Account
     * @return OpenBankTransactionAccountDto
     */
    public OpenBankTransactionAccountDto getOther_account() {
        return other_account;
    }

    /**
     * Sets the Account known as Other Account
     * @param other_account OpenBankTransactionAccountDto to set
     */
    public void setOther_account(OpenBankTransactionAccountDto other_account) {
        this.other_account = other_account;
    }

    /**
     * Transforms this into a TransactionDto
     * @return Non-null TransactionDto
     */
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
