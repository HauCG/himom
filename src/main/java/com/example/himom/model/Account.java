package com.example.himom.model;

public class Account {
    private String accountId;
    private String accountName;
    private String accountPassword;
    private String accountEmail;

    public Account(String accountId, String accountName, String accountPassword, String accountEmail) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountEmail = accountEmail;
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

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
}
