package com.alekstar.yourmoneysaver.domain;

import java.util.Date;
import java.util.LinkedList;

import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

public class Operation {
    Cash account;
    String comment;
    Date date;
    String receiver;
    LinkedList<Transaction> transactions;

    public Operation(Cash account, String receiver,
            LinkedList<Transaction> transactions, String comment, Date date) {
        setAccount(account);
        setReceiver(receiver);
        setTransactions(transactions);
        setComment(comment);
        setDate(date);
    }

    public Cash getAccount() {
        return account;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    public String getReceiver() {
        return receiver;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public void setAccount(Cash account) {
        if (account == null) {
            throw new ArgumentIsNullException("account");
        }
        this.account = account;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(Date date) {
        if (date == null) {
            throw new ArgumentIsNullException("date");
        }
        this.date = date;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setTransactions(LinkedList<Transaction> transactions) {
        if (transactions == null) {
            throw new ArgumentIsNullException("transactions");
        }
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException("There must be one or more "
                    + "transactions.");
        }
        this.transactions = transactions;
    }
}
