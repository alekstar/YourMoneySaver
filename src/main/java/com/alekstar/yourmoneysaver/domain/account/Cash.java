package com.alekstar.yourmoneysaver.domain.account;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import com.alekstar.yourmoneysaver.domain.money.CommonMoneyComparator;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class Cash implements Account {
    String name;
    String comments;
    Currency currency;
    Map<Currency, Money> rest;

    public Cash(String name, Currency currency, String comments) {
        setName(name);
        setCurrency(currency);
        setRest(new TreeMap<Currency, Money>());
        setComments(comments);
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money defineRest(Currency currency) {
        Money restInConcretteCurrency = getRest().get(currency);
        if (restInConcretteCurrency == null) {
            return CommonMoney.create(0, currency);
        }
        return restInConcretteCurrency;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new ArgumentIsNullException("name");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        this.name = name;
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new ArgumentIsNullException("currency");
        }
        this.currency = currency;
    }

    @Override
    public Boolean isClosed() {
        // TODO if account have last operation of closing account then true,
        // else false
        return new Boolean(false);
    }

    @Override
    public String defineAccountTypeName() {
        return "Cash";
    }

    @Override
    public void put(Money money) {
        addToRest(money);
    }

    @Override
    public void get(double amount, Currency currency) {
        subtractFromRest(CommonMoney.create(amount, currency));
    }

    private Map<Currency, Money> getRest() {
        return rest;
    }

    private void setRest(Map<Currency, Money> rest) {
        this.rest = rest;
    }

    private void addToRest(Money money) {
        Comparator<Money> moneyComparator = CommonMoneyComparator.create();
        if (moneyComparator.compare(money,
                CommonMoney.create(0, money.getCurrency())) < 0) {
            throw new IllegalArgumentException("Can't put "
                    + money.getDecimalPart() + " "
                    + money.getCurrency().getIsoCode() + " to Cash account.");
        }
        Money restInConcretteCurrency = getRest().get(money.getCurrency());
        if (restInConcretteCurrency != null) {
            restInConcretteCurrency = restInConcretteCurrency.add(money);
            swapWithNewRest(restInConcretteCurrency);
        } else {
            getRest().put(money.getCurrency(), money);
        }
    }

    private void subtractFromRest(Money money) {
        Comparator<Money> moneyComparator = CommonMoneyComparator.create();
        if (moneyComparator.compare(money,
                CommonMoney.create(0, money.getCurrency())) < 0) {
            throw new IllegalArgumentException("Can't get "
                    + money.getDecimalPart() + " "
                    + money.getCurrency().getIsoCode() + " from Cash account.");
        }
        Money rest = defineRest(money.getCurrency());
        if (moneyComparator.compare(rest, money) < 0) {
            throw new InsufficientMoneyException("Trying to get "
                    + money.getDecimalPart() + " "
                    + money.getCurrency().getIsoCode()
                    + " from cash account where the rest of money is "
                    + rest.getDecimalPart() + " "
                    + rest.getCurrency().getIsoCode());
        }
        swapWithNewRest(rest.subtract(money));
    }

    private void swapWithNewRest(Money newRest) {
        getRest().remove(newRest.getCurrency());
        getRest().put(newRest.getCurrency(), newRest);
    }
}
