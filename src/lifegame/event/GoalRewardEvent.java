package lifegame.event;

import lifegame.Player;

public class GoalRewardEvent extends AbstractEvent {

	private final static int GOAL_REWARD[] = new int[] {30000000,10000000, 2000000};

	private int lastTurn = 0;

	private int currentRank = 0;

	public GoalRewardEvent() {
		super(0);
	}

	@Override
	public void processEvent(Player player, int turnNumber) {
		if (this.lastTurn != turnNumber) {
			this.lastTurn = turnNumber;
			this.currentRank++;
		}

		if (this.currentRank <= GOAL_REWARD.length) {
			int reward = GOAL_REWARD[this.currentRank - 1];

			System.out.println("ゴールしました。" + this.currentRank + "番目にゴールしたので、報酬として" + reward + "円もらいました。");
			player.wallet.addMoney(reward);
		} else {
			System.out.println("ゴールしました。" + this.currentRank + "番目にゴールしたので、報酬はありません。");
		}
	}
}
