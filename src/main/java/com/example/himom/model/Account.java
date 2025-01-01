package com.example.himom.model;

public class Account {
    private String accountId;
    private String accountName;
    private String accountPassword;

    public Account(String accountId, String accountName, String accountPassword) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
    }

    public Account() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
