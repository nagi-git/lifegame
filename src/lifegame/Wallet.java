package lifegame;

/**
 * プレイヤーの財布
 * @author minami
 */
public class Wallet {

	/** 所持金額 */
	private int money;

	/**
	 * コンストラクタ
	 * @param 最初の所持金額
	 */
	public Wallet(int money) {
		this.money = money;
	}

	/**
	 * 所持金額に引数の金額を加算し、加算後の所持金額を返す
	 * @param money 加算する金額
	 * @return 加算後の所持金額
	 */
	public int addMoney(int money) {
		this.money += money;
		return this.money;
	}

	/**
	 * 所持金額を取得
	 * @return 所持金額
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Integer.toString(this.money);
	}

}
