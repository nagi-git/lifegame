package lifegame;

public class Wallet extends Object {

	private int money;

	public Wallet(int money) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.money = money;
	}

	public int addMoney(int money) {
		this.money += money;
//		System.out.println("現在の所持金は" + this.money + "円です。");
		return this.money;
	}

	@Override
	public String toString() {
		return Integer.toString(this.money);
	}

}
