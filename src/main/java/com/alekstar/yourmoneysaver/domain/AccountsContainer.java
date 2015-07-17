package com.alekstar.yourmoneysaver.domain;

import java.util.List;

public class AccountsContainer {
    List<Cash> accounts;

    // TODO add constructor and factory method

    public int add(Cash account) {
        verifyAccounts();
        accounts.add(account);
        return (accounts.size() - 1);
    }

    public Cash get(int index) {
        verifyAccounts();
        return accounts.get(index);
    }

    private void verifyAccounts() {
        if (accounts == null) {
            throw new IllegalStateException(
                    "Accounts container is not initialized.");
        }
    }

    public void remove(int index) {
        verifyAccounts();
        accounts.remove(index);
    }
}
