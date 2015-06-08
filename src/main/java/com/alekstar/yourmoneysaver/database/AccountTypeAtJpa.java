package com.alekstar.yourmoneysaver.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alekstar.yourmoneysaver.AccountType;

@Entity
@Table(name = "account_types")
public class AccountTypeAtJpa implements AccountTypeEntity {
    private AccountType accountType;
    private long id;

    public AccountTypeAtJpa() {
        setAccountType(new AccountType(defineInvalidAccountTypeName(),
                defineInvalidAccountTypeComments()));
    }

    private static String defineInvalidAccountTypeComments() {
        return "This account type is invalid";
    }

    private static String defineInvalidAccountTypeName() {
        return "Invalid account type";
    }

    @Override
    public void setName(String name) {
        getAccountType().setName(name);
    }

    @Override
    @Column(name = "name", nullable = false)
    public String getName() {
        return getAccountType().getName();
    }

    @Override
    public void setComments(String comments) {
        getAccountType().setComments(comments);
    }

    @Override
    @Column(name = "comments", nullable = true)
    public String getComments() {
        return getAccountType().getComments();
    }

    @Transient
    private AccountType getAccountType() {
        return this.accountType;
    }

    private void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getId() {
        return this.id;
    }
}
