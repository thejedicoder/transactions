package com.cory.transactions.ac.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the Details of a Transaction at OpenBank
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionDetailsDto {

    private String type;
    private String description;
    private OpenBankTransactionDetailsValueDto value;

    /**
     * Gets the Transaction Type
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Transaction Type
     * @param type String to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the Description of the Transaction
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description of the Transaction
     * @param description String to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Value of the Transaction
     * @return OpenBankTransactionDetailsValueDto
     */
    public OpenBankTransactionDetailsValueDto getValue() {
        return value;
    }

    /**
     * Sets the Value of the Transaction
     * @param value OpenBankTransactionDetailsValueDto to set
     */
    public void setValue(OpenBankTransactionDetailsValueDto value) {
        this.value = value;
    }
}
