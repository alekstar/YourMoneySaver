package com.alekstar.yourmoneysaver.domain;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class AccountType {
    private String name;
    private String comments;

    public AccountType(String name, String comments) {
        setName(name);
        setComments(comments);
    }

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public void setName(String name) {
        if (name == null) {
            throw new ArgumentIsNullException("name");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        this.name = name;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
