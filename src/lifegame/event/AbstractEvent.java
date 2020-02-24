package lifegame.event;

import lifegame.Player;

/**
 * イベントの親クラス
 * @author minami
 */
public abstract class AbstractEvent {

	int depositAmount;

	/**
	 * コンストラクタ
	 * @param depositAmount 入出金額
	 */
	protected AbstractEvent(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	/**
	 * イベントプロセスのクラス
	 * @param player プレイヤー
	 * @param turnNumber ターン数
	 */
	public void processEvent(Player player, int turnNumber) {
		System.out.println(this.getActionMessage());
		player.getWallet().addMoney(depositAmount);
	}

	/**
	 * メッセージを取得
	 */
	public String getActionMessage() {
		return "";
	}

}
