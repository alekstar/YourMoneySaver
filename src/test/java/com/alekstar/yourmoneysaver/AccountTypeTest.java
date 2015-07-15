package com.alekstar.yourmoneysaver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.domain.AccountType;
import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class AccountTypeTest {

    @Test
    public void shouldCreateAccountTypeWithNameNiceAccountType() {
        String expectedName = "Nice Account Type";
        AccountType accountType = new AccountType(expectedName, null);
        assertEquals(expectedName, accountType.getName());
    }

    @Test
    public void shouldCreateAccountTypeWithNullComments() {
        String expectedName = "Nice Account Type";
        AccountType accountType = new AccountType(expectedName, null);
        assertNull(accountType.getComments());
    }

    @Test(expected = ArgumentIsNullException.class)
    public void shouldThrowArgumentIsNullExceptionIfNameIsNullAndCommentsIsNull() {
        @SuppressWarnings("unused")
        AccountType accountType = new AccountType(null, null);
        fail();
    }

    @Test(expected = ArgumentIsNullException.class)
    public void shouldThrowArgumentIsNullExceptionIfNameIsNullAndCommentsIsNotNull() {
        @SuppressWarnings("unused")
        AccountType accountType = new AccountType(null, "Some comments");
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfNameIsEmpty() {
        @SuppressWarnings("unused")
        AccountType accountType = new AccountType("", "Some comments");
        fail();
    }
}
