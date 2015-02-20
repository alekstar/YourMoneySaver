package YourMoneySaver;
public class Currency {
	private String name;
	private String isoCode;
	private String sign;
	
	public String getSign() {
		return sign;
	}

	private void setSign(String sign) {
		this.sign = sign;
	}

	public String getIsoCode() {
		return isoCode;
	}
	
	private void setIsoCode(String iSOCode) {
		isoCode = iSOCode;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Currency(String name, String isoCode, String sign) {
		setName(name);
		setIsoCode(isoCode);
		setSign(sign);
	}
}
