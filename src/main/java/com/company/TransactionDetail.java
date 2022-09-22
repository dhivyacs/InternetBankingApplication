package com.company;

import java.time.LocalDate;

public class TransactionDetail {

    private LocalDate transactionDate;
    private String vendor;
    private String transactionType;
    private Double amount;
    private String category;

    public TransactionDetail(LocalDate transactionDate, String vendor, String transactionType, Double amount, String category) {
        super();
        this.transactionDate = transactionDate;
        this.vendor = vendor;
        this.transactionType = transactionType;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "TransactionDetail [transactionDate= " +transactionDate + ", vendor= " +vendor +
        ", transactionType= " +transactionType + ", amount= " +amount + ", category= " +category + "]";
    }
}
