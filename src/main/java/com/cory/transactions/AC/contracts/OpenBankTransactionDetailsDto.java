package com.cory.transactions.AC.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionDetailsDto {

    private String type;
    private String description;
    private OpenBankTransactionDetailsValueDto value;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpenBankTransactionDetailsValueDto getValue() {
        return value;
    }

    public void setValue(OpenBankTransactionDetailsValueDto value) {
        this.value = value;
    }
}
