package YourMoneySaver;

public class TransactionCategory {
	public enum Sign {
		PLUS, MINUS
	};

	private TransactionCategory parent;
	private String name;
	private Sign sign;

	public Sign getDefaultSign() {
		return Sign.PLUS;
	}

	public TransactionCategory getParent() {
		return parent;
	}

	public void setParent(TransactionCategory parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		if(name == null) {
			throw new IllegalArgumentException("Argument name is null.");
		}
		if(name.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty.");
		}
		this.name = name;
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

	public TransactionCategory(TransactionCategory parent, String name,
            Sign sign) {
	    setParent(parent);
	    setName(name);
	    setSign(sign);
    }
}
