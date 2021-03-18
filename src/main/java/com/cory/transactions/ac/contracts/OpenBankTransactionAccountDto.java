package com.cory.transactions.ac.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the an Account on a Transaction at OpenBank
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionAccountDto {

    private String id;
    private String number;
    private OpenBankTransactionAccountHolderDto holder;
    private OpenBankTransactionAccountMetadataDto metadata;

    /**
     * Gets the id
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id String to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the number
     * @return String
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number
     * @param number String to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets the Holder of the Account
     * @return OpenBankTransactionAccountHolderDto
     */
    public OpenBankTransactionAccountHolderDto getHolder() {
        return holder;
    }

    /**
     * Sets the Holder of the Account
     * @param holder OpenBankTransactionAccountHolderDto to set
     */
    public void setHolder(OpenBankTransactionAccountHolderDto holder) {
        this.holder = holder;
    }

    /**
     * Gets the Metadata for this Account
     * @return OpenBankTransactionAccountMetadataDto
     */
    public OpenBankTransactionAccountMetadataDto getMetadata() {
        return metadata;
    }

    /**
     * Sets the Metadata for this Account
     * @param metadata OpenBankTransactionAccountMetadataDto to set
     */
    public void setMetadata(OpenBankTransactionAccountMetadataDto metadata) {
        this.metadata = metadata;
    }
}
