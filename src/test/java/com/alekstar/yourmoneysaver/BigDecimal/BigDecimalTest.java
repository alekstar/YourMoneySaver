package com.alekstar.yourmoneysaver.BigDecimal;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {
    @Test
    public void shouldBe2Dot34() {
        BigDecimal first = new BigDecimal("2.34");
        assertEquals("2.34", first.toString());
    }
}
