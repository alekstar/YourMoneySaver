package YourMoneySaver;

public class Account {
	Money rest;
	AccountType accountType;
	String name;
	String comments;

	public Money getRest() {
		return rest;
	}

	public void setRest(Money rest) throws IllegalArgumentException {
		if(rest == null) {
			throw new IllegalArgumentException("Argument rest is null.");
		}
		this.rest = rest;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		if(accountType == null) {
			throw new IllegalArgumentException("Argument accountType is "
					+ "null.");
		}
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Account(String name, AccountType accountType, Money rest,
            String comments) throws IllegalArgumentException {
		setRest(rest);
		setAccountType(accountType);
		setName(name);
		setComments(comments);
    }
	
	
}
