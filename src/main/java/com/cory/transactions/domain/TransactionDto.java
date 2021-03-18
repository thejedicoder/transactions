package com.cory.transactions.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a Transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDto {

    private String id;
    private String accountId;
    private String counterpartyAccount;
    private String counterpartyName;
    private String counterpartyLogoPath;
    private Double instructedAmount;
    private String instructedCurrency;
    private Double transactionAmount;
    private String transactionCurrency;
    private String transactionType;
    private String description;

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
     * Gets the AccountId
     * @return String
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the AccountId
     * @param accountId String to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the Counterparty Account
     * @return String
     */
    public String getCounterpartyAccount() {
        return counterpartyAccount;
    }

    /**
     * Sets the Counterparty Account
     * @param counterpartyAccount String to set
     */
    public void setCounterpartyAccount(String counterpartyAccount) {
        this.counterpartyAccount = counterpartyAccount;
    }

    /**
     * Gets the Counterparty Name
     * @return String
     */
    public String getCounterpartyName() {
        return counterpartyName;
    }

    /**
     * Sets the Counterparty Name
     * @param counterpartyName String to set
     */
    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }

    /**
     * Gets the Counterparty Logo Path
     * @return String
     */
    public String getCounterpartyLogoPath() {
        return counterpartyLogoPath;
    }

    /**
     * Sets the Counterparty Logo Path
     * @param counterpartyLogoPath String to set
     */
    public void setCounterpartyLogoPath(String counterpartyLogoPath) {
        this.counterpartyLogoPath = counterpartyLogoPath;
    }

    /**
     * Gets the Instructed Amount
     * @return Double
     */
    public Double getInstructedAmount() {
        return instructedAmount;
    }

    /**
     * Sets the Instructed Amount
     * @param instructedAmount Double to set
     */
    public void setInstructedAmount(Double instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    /**
     * Gets the Instructed Currency
     * @return String
     */
    public String getInstructedCurrency() {
        return instructedCurrency;
    }

    /**
     * Sets the Instructed Currency
     * @param instructedCurrency String to set
     */
    public void setInstructedCurrency(String instructedCurrency) {
        this.instructedCurrency = instructedCurrency;
    }

    /**
     * Gets the Transaction Amount
     * @return Double
     */
    public Double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the Transaction Amount
     * @param transactionAmount Double to set
     */
    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * Gets the Transaction Currency
     * @return String
     */
    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    /**
     * Sets the Transaction Currency
     * @param transactionCurrency String to set
     */
    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    /**
     * Gets the Transaction Type
     * @return String
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the Transaction Type
     * @param transactionType String to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Gets the Description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description
     * @param description String to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
