package com.yourmoneysaver;

public class TransactionCategory {
	public enum Sign {
		MINUS, PLUS
	};

	private String name;
	private TransactionCategory parent;
	private Sign sign;

	public TransactionCategory(TransactionCategory parent, String name,
            Sign sign) {
	    setParent(parent);
	    setName(name);
	    setSign(sign);
    }

	public Sign getDefaultSign() {
		return Sign.PLUS;
	}

	public String getName() {
		return name;
	}

	public TransactionCategory getParent() {
		return parent;
	}

	public Sign getSign() {
		return sign;
	}

	public void setName(String name){
		if(name == null) {
			throw new ArgumentIsNullException("name");
		}
		if(name.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty.");
		}
		this.name = name;
	}

	public void setParent(TransactionCategory parent) {
		this.parent = parent;
	}

	public void setSign(Sign sign) {
		if(sign == null) {
			this.sign = getDefaultSign();
		} else {
			this.sign = sign;
		}
	}
}
