package main.YourMoneySaver;

import java.util.Date;
import java.util.LinkedList;

public class Operation {
	Account account;
	String comment;
	Date date;
	String receiver;
	LinkedList<Transaction> transactions;

	public Operation(Account account, String receiver,
            LinkedList<Transaction> transactions, String comment, Date date) {
	    setAccount(account);
	    setReceiver(receiver);
	    setTransactions(transactions);
	    setComment(comment);
	    setDate(date);
    }

	public Account getAccount() {
		return account;
	}

	public String getComment() {
		return comment;
	}

	public Date getDate() {
		return date;
	}

	public String getReceiver() {
		return receiver;
	}

	public LinkedList<Transaction> getTransactions() {
		return transactions;
	}

	public void setAccount(Account account) {
		if(account == null) {
			throw new IllegalArgumentException("Argument account is null.");
		}
		this.account = account;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDate(Date date) {
		if(date == null) {
			throw new IllegalArgumentException("Argument date is null.");
		}
		this.date = date;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public void setTransactions(LinkedList<Transaction> transactions) {
		if(transactions == null) {
			throw new IllegalArgumentException("Argument transactions is "
					+ "null.");
		}
		if(transactions.isEmpty()) {
			throw new IllegalArgumentException("There must be one or more "
					+ "transactions.");
		}
		this.transactions = transactions;
	}
}
