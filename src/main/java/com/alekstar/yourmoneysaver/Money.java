package com.alekstar.yourmoneysaver;

public class Money {

    long base;
    long coins;
    int coinsDigitsNumber = getDefaultCoinsDigitsNumber();
    Currency currency;

    public Money(Currency currency, long base, long coins) {
        this(currency, base, coins, getDefaultCoinsDigitsNumber());
    }

    public Money(Currency currency, long base, long coins, int coinsDigitsNumber) {
        setCurrency(currency);
        setBase(base);
        setCoins(coins);
        setCoinsDigitsNumber(coinsDigitsNumber);
    }

    public static int getDefaultCoinsDigitsNumber() {
        return 2;
    }

    public Money add(Money another) {
        checkForOperations(another);
        long base = this.getBase() + another.getBase();
        long coins = this.getCoins() + another.getCoins();
        if (coins > defineMaximumCoinsAccessable()) {
            base++;
            coins -= coins - coins % (defineMaximumCoinsAccessable() + 1.0);
        }
        return new Money(getCurrency(), base, coins, getCoinsDigitsNumber());
    }

    private void checkForOperations(Money another) {
        if (another.getCurrency() != getCurrency()) {
            throw new RuntimeException("Currencies are not equal.");
        }
        if (another.getCoinsDigitsNumber() != getCoinsDigitsNumber()) {
            throw new RuntimeException("Moneys have different coins digits "
                    + "number.");
        }
    }

    private long defineMaximumCoinsAccessable() {
        return (long) (Math.pow(10, getCoinsDigitsNumber()) - 1.0);
    }

    public long getBase() {
        return base;
    }

    public long getCoins() {
        return coins;
    }

    public int getCoinsDigitsNumber() {
        return coinsDigitsNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setBase(long base) {
        this.base = base;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    private void setCoinsDigitsNumber(int coinsDigitsNumber) {
        this.coinsDigitsNumber = coinsDigitsNumber;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Money substract(Money another) {
        checkForOperations(another);
        long base = this.getBase() - another.getBase();
        long coins = this.getCoins() - another.getCoins();
        if (coins < 0) {
            base--;
            coins = defineMaximumCoinsAccessable() + 1 + coins;
        }
        return new Money(getCurrency(), base, coins, getCoinsDigitsNumber());
    }
}
