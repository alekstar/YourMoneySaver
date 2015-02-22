package main.YourMoneySaver;
public class Currency {
	private String name;
	private String isoCode;
	private String sign;
	
	public Currency(String name, String isoCode, String sign) {
		setName(name);
		setIsoCode(isoCode);
		setSign(sign);
	}

	public String getIsoCode() {
		return isoCode;
	}

	public String getName() {
		return name;
	}
	
	public String getSign() {
		return sign;
	}

	private void setIsoCode(String iSOCode) {
		isoCode = iSOCode;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setSign(String sign) {
		this.sign = sign;
	}
}
