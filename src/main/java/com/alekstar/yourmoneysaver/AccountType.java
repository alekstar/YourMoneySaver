package com.alekstar.yourmoneysaver;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class AccountType {
    private String name;

    public AccountType(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null) {
            throw new ArgumentIsNullException("name");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        this.name = name;
    }
}
