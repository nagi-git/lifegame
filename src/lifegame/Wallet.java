package lifegame;

public class Wallet {

	private int money;

	public Wallet(int money) {
		this.money = money;
	}

	public int addMoney(int money) {
		this.money += money;
		return this.money;
	}

	@Override
	public String toString() {
		return Integer.toString(this.money);
	}

}
