package com.alekstar.yourmoneysaver.ui.javafx;

import com.alekstar.yourmoneysaver.domain.Cash;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

public class AccountsTableDataStructure {
    private Cash account;
    private String name;
    private String type;
    private String rest;
    private String currencyCode;
    private String comments;

    private AccountsTableDataStructure() {

    }

    public static AccountsTableDataStructure create(Cash account) {
        AccountsTableDataStructure accountsTableDataStructure =
                new AccountsTableDataStructure();
        accountsTableDataStructure.setAccount(account);
        accountsTableDataStructure.setName(account.getName());
        accountsTableDataStructure.setType(account.getAccountType().getName());
        StringBuilder restStringBuilder = new StringBuilder();
        restStringBuilder.append(account.defineRest().getBase());
        restStringBuilder.append(accountsTableDataStructure
                .getDefaultSeparatorForNumbers());
        restStringBuilder.append(account.defineRest().getCoins());
        accountsTableDataStructure.setRest(restStringBuilder.toString());
        accountsTableDataStructure.setCurrencyCode(account.defineRest()
                .getCurrency().getIsoCode());
        accountsTableDataStructure.setComments(account.getComments());
        return accountsTableDataStructure;
    }

    public Cash getAccount() {
        return account;
    }

    public String getComments() {
        return comments;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    private char getDefaultSeparatorForNumbers() {
        return ',';
    }

    public String getName() {
        return name;
    }

    public String getRest() {
        return rest;
    }

    public String getType() {
        return type;
    }

    public void setAccount(Cash account) {
        if (account == null) {
            throw new ArgumentIsNullException("account");
        }
        this.account = account;
    }

    private void setComments(String comments) {
        this.comments = comments;
    }

    private void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRest(String rest) {
        this.rest = rest;
    }

    private void setType(String type) {
        this.type = type;
    }
}
