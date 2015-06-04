package com.alekstar.yourmoneysaver;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTypeTest {

    @Test
    public void shouldCreateAccountTypeWithNameNiceAccountType() {
        String expectedName = "Nice Account Type";
        AccountType accountType = new AccountType(expectedName, null);
        assertEquals(expectedName, accountType.getName());
    }
}
