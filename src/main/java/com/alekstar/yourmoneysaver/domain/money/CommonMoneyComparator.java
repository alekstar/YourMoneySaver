package com.alekstar.yourmoneysaver.domain.money;

import java.math.BigDecimal;
import java.util.Comparator;

public class CommonMoneyComparator implements Comparator<Money> {

    protected CommonMoneyComparator() {
    }

    public static CommonMoneyComparator create() {
        return new CommonMoneyComparator();
    }

    @Override
    public int compare(Money o1, Money o2) {
        if (o1.getCurrency() != o2.getCurrency()) {
            throw new IllegalArgumentException(
                    "Currencies for to comparable Money objects should be equal.");
        }
        return new BigDecimal(o1.getDecimalPart()).compareTo(new BigDecimal(o2
                .getDecimalPart()));
    }
}
