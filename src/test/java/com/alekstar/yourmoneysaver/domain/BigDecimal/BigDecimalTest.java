package com.alekstar.yourmoneysaver.domain.BigDecimal;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.junit.Test;

public class BigDecimalTest {
    @Test
    public void shouldBe2Dot34() {
        BigDecimal bigDecimal = new BigDecimal("2.34");
        assertEquals("2.34", bigDecimal.toString());
    }

    @Test
    public void shouldBe2Dot00() {
        BigDecimal bigDecimal =
                new BigDecimal("2", new MathContext(defineDefaultPrecision(),
                        RoundingMode.HALF_UP));
        String result =
                defineStringInFormat(bigDecimal, defineDefaultPrecision());
        String expected = defineExpectedValueForShouldBe2Dot00TestCase();
        assertEquals(expected, result);
    }

    @Test
    public void shouldBeMinus2Dot34() {
        BigDecimal bigDecimal = new BigDecimal("-2.34");
        assertEquals("-2.34", bigDecimal.toString());
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowNumberFormatException() {
        new BigDecimal("3,56");
        fail();
    }

    private int defineDefaultPrecision() {
        return 2;
    }

    private String defineExpectedValueForShouldBe2Dot00TestCase() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('2');
        stringBuilder.append(defineDecimalSeparator());
        stringBuilder.append('0');
        stringBuilder.append('0');
        String expected = stringBuilder.toString();
        return expected;
    }

    private char defineDecimalSeparator() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        return decimalFormatSymbols.getDecimalSeparator();
    }

    private String defineStringInFormat(BigDecimal bigDecimal,
            int digitsAfterSeparator) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(digitsAfterSeparator);
        decimalFormat.setMinimumFractionDigits(digitsAfterSeparator);
        decimalFormat.setGroupingUsed(false);
        String result = decimalFormat.format(bigDecimal);
        return result;
    }
}
