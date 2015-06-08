package com.alekstar.yourmoneysaver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class AccountTypeTest {

    @Test
    public void shouldCreateAccountTypeWithNameNiceAccountType() {
        String expectedName = "Nice Account Type";
        AccountType accountType = new AccountType(expectedName, null);
        assertEquals(expectedName, accountType.getName());
    }

    @Test(expected = ArgumentIsNullException.class)
    public void shouldThrowArgumentIsNullExceptionIfNameIsNullAndCommentsIsNull() {
        @SuppressWarnings("unused")
        AccountType accountType = new AccountType(null, null);
        fail();
    }
}
