package YourMoneySaver;

public class AccountType {
	private String name;

	public String getName() {
		return name;
	}

	private void setName(String name) throws IllegalArgumentException {
		if(name == null) {
			throw new IllegalArgumentException("Argument name is null.");
		}
		if(name.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty.");
		}
		this.name = name;
	}
	
	public AccountType(String name) throws IllegalArgumentException {
		setName(name);
	}
}
