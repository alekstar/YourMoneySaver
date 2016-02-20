package com.alekstar.yourmoneysaver.domain.account;

import java.util.*;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.Operation;
import com.alekstar.yourmoneysaver.domain.Transaction;
import com.alekstar.yourmoneysaver.domain.TransactionCategory;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import com.alekstar.yourmoneysaver.domain.money.CommonMoneyComparatorByDecimalPart;
import com.alekstar.yourmoneysaver.domain.money.Money;

// TODO History
// TODO Categories of operations

public class Cash implements Account {
    String name;
    String comments;
    Currency currency;
    Map<Currency, Money> rest;
    List<Operation> operations;

    public Cash(String name, Currency currency, String comments) {
        setName(name);
        setCurrency(currency);
        setRest(new TreeMap<>());
        setComments(comments);
        operations = new ArrayList<>();
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
        return false;
    }

    @Override
    public String defineAccountTypeName() {
        return "Cash";
    }

    @Override
    public void put(Money money) {
        addToRest(money);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(Transaction.Sign.PLUS, money, new TransactionCategory(null, "Category", TransactionCategory.Sign.PLUS), ""));
        operations.add(new Operation(this, "", transactions, "", new Date()));
    }

    @Override
    public void get(double amount, Currency currency) {
        subtractFromRest(CommonMoney.create(amount, currency));
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    private Map<Currency, Money> getRest() {
        return rest;
    }

    private void setRest(Map<Currency, Money> rest) {
        this.rest = rest;
    }

    private void addToRest(Money requestedSum) {
        Comparator<Money> moneyComparator = CommonMoneyComparatorByDecimalPart.create();
        if (moneyComparator.compare(requestedSum,
                CommonMoney.create(0, requestedSum.getCurrency())) < 0) {
            throw new IllegalArgumentException("Can't put "
                    + requestedSum.getDecimalPart() + " "
                    + requestedSum.getCurrency().getIsoCode() + " to Cash account.");
        }
        Money restInConcretteCurrency = getRest().get(requestedSum.getCurrency());
        if (restInConcretteCurrency != null) {
            restInConcretteCurrency = restInConcretteCurrency.add(requestedSum);
            swapWithNewRest(restInConcretteCurrency);
        } else {
            getRest().put(requestedSum.getCurrency(), requestedSum);
        }
    }

    private void subtractFromRest(Money requestedSum) {
        Comparator<Money> moneyComparator = CommonMoneyComparatorByDecimalPart.create();
        if (moneyComparator.compare(requestedSum,
                CommonMoney.create(0, requestedSum.getCurrency())) < 0) {
            throw new IllegalArgumentException("Can't get "
                    + requestedSum.getDecimalPart() + " "
                    + requestedSum.getCurrency().getIsoCode() + " from Cash account.");
        }
        Money newRest = defineRest(requestedSum.getCurrency());
        if (moneyComparator.compare(newRest, requestedSum) < 0) {
            throw new InsufficientMoneyException(newRest, requestedSum);
        }
        swapWithNewRest(newRest.subtract(requestedSum));
    }

    private void swapWithNewRest(Money newRest) {
        getRest().remove(newRest.getCurrency());
        getRest().put(newRest.getCurrency(), newRest);
    }
}
