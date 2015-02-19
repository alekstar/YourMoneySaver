package YourMoneySaver;

public class Transaction {
	public enum Sign {
		MINUS, PLUS
	};

	private Sign sign;
	private Money sum;
	private TransactionCategory transactionCategory;
	private String comment;
	
	public Sign getDefaultSign() {
		return Sign.PLUS;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		if(sign == null) {
			this.sign = getDefaultSign();
		} else {
			this.sign = sign;
		}
	}

	public Money getSum() {
		return sum;
	}

	public void setSum(Money sum) {
		this.sum = sum;
	}

	public TransactionCategory getTransactionCategory() {
		return transactionCategory;
	}

	public void setTransactionCategory(TransactionCategory transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Transaction(Sign sign, Money sum,
            TransactionCategory transactionCategory, String comment) {
	    setSign(sign);
	    setTransactionCategory(transactionCategory);
	    setComment(comment);
    }

}
