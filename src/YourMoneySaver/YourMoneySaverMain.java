package YourMoneySaver;
public class YourMoneySaverMain {

	public static void main(String[] args) {
		Currency currency = new Currency("Гривны", "980", "₴");
		Money first = new Money(currency, 56, 54);
		Money second = new Money(currency, 57, 57);
		Money result = first.add(second);
		System.out.println(result.getBase() + "." + result.getCoins());
	}

}
