package YourMoneySaver;
public class Currency {
	private String name;
	private String isoCode;
	
	public String getIsoCode() {
		return isoCode;
	}
	
	public void setIsoCode(String iSOCode) {
		isoCode = iSOCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Currency(String name, String isoCode) {
		setName(name);
		setIsoCode(isoCode);
	}	
}
