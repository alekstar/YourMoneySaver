package com.alekstar.yourmoneysaver;

import java.util.ArrayList;
import java.util.TreeSet;

public class YourMoneySaverMain {

    public static void main(String[] args) {
        TreeSet<Currency> currencies = new TreeSet<Currency>();
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴");
        Currency usd = new Currency("United States dollar", "USD", "$");
        Currency rub = new Currency("Russian ruble", "RUB", "₽");
        currencies.add(uah);
        currencies.add(rub);
        currencies.add(usd);
        System.out.println("After adding:");
        ArrayList<Currency> observableList =
                new ArrayList<Currency>(currencies);
        for (Currency currency : observableList) {
            System.out.println(currency.getName());
        }
        currencies.remove(rub);
        System.out.println();
        System.out.println("After removing ruble:");
        for (Currency currency : observableList) {
            System.out.println(currency.getName());
        }
        currencies.remove(rub);
    }
}
