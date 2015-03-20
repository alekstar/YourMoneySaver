package com.alekstar.yourmoneysaver;

public class Transaction {
    public enum Sign {
        MINUS, PLUS
    };

    private String comment;
    private Sign sign;
    private Money sum;
    private TransactionCategory transactionCategory;

    public Transaction(Sign sign, Money sum,
            TransactionCategory transactionCategory, String comment) {
        setSign(sign);
        setTransactionCategory(transactionCategory);
        setComment(comment);
    }

    public String getComment() {
        return comment;
    }

    public Sign getDefaultSign() {
        return Sign.PLUS;
    }

    public Sign getSign() {
        return sign;
    }

    public Money getSum() {
        return sum;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSign(Sign sign) {
        if (sign == null) {
            this.sign = getDefaultSign();
        } else {
            this.sign = sign;
        }
    }

    public void setSum(Money sum) {
        this.sum = sum;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

}
