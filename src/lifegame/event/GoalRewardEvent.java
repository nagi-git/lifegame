package lifegame.event;

import lifegame.Player;

/**
 * イベントの子クラス<br>
 * ゴールしたら報酬をもらうイベント
 * @author minami
 */
public class GoalRewardEvent extends AbstractEvent {

	/** ゴール時の報酬金額 */
	private final static int GOAL_REWARD[] = new int[] {30000000,10000000, 5000000};

	/** 最後のターン数 */
	private int lastTurnNumber = 0;

	/** ゴールした順番 */
	private int currentRank = 0;

	/**
	 * コンストラクタ
	 */
	public GoalRewardEvent() {
		super(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processEvent(Player player, int turnNumber) {

		// 前にゴールしたplayerのターン数が現在のplayerのターン数と異なるとき、
		//   1）最後のターン数(lastTurnNumber)=現在のターン数(turnNumber)になる
		//   2）順位が1増える
		if (this.lastTurnNumber != turnNumber) {
			this.lastTurnNumber = turnNumber;
			this.currentRank++;
		}

		// ゴールした順位が3位以内の場合、報酬(GOAL_REWARD)がもらえる
		if (this.currentRank <= GOAL_REWARD.length) {

			// ゴールした順番の報酬額を配列から取得
			int reward = GOAL_REWARD[this.currentRank - 1];

			System.out.println("ゴールしました。" + this.currentRank + "番目にゴールしたので、報酬として" + reward + "円もらいました。");
			player.getWallet().addMoney(reward);
		} else {
			System.out.println("ゴールしました。" + this.currentRank + "番目にゴールしたので、報酬はありません。");
		}
	}
}
