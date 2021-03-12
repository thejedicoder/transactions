package com.cory.transactions.AC.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransactionAccountDto {

    private String id;
    private String number;
    private OpenBankTransactionAccountHolderDto holder;
    private OpenBankTransactionAccountMetadataDto metadata;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public OpenBankTransactionAccountHolderDto getHolder() {
        return holder;
    }

    public void setHolder(OpenBankTransactionAccountHolderDto holder) {
        this.holder = holder;
    }

    public OpenBankTransactionAccountMetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(OpenBankTransactionAccountMetadataDto metadata) {
        this.metadata = metadata;
    }
}
