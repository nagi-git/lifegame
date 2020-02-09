package lifegame;

public class Wallet {

	private int money;

	public Wallet(int money) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.money = money;
	}

	int addMoney(int money) {
		this.money += money;
		System.out.println("現在の所持金は" + this.money + "円です。");
		return this.money;
	}

}
