package com.alekstar.yourmoneysaver.BigDecimal;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.junit.Test;

public class BigDecimalTest {
    @Test
    public void shouldBe2Dot34() {
        BigDecimal first = new BigDecimal("2.34");
        assertEquals("2.34", first.toString());
    }

    @Test
    public void shouldBe2Dot00() {
        BigDecimal first =
                new BigDecimal("2", new MathContext(2, RoundingMode.HALF_UP));
        String result = defineStringInFormat(first, 2);
        String expected = defineExpectedValueForShouldBe2Dot00TestCase();
        assertEquals(expected, result);
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
