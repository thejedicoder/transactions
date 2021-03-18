package com.cory.transactions.ac.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents an Account Holder for an OpenBank Transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionAccountHolderDto {

    private String name;

    /**
     * Gets the name for this Account Holder
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this Account Holder
     * @param name String to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
