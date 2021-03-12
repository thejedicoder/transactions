package com.cory.transactions.AC.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the Account Metadata for an OpenBank Transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionAccountMetadataDto {

    private String image_URL;

    /**
     * Gets the Image URL for the Account
     * @return String
     */
    public String getImage_URL() {
        return image_URL;
    }

    /**
     * Sets the Image URL for the Account
     * @param image_URL String to set
     */
    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }
}
