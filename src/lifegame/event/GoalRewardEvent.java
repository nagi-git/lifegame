package lifegame.event;

public class GoalRewardEvent extends AbstractEvent {

	private final static int GOAL_REWARD = 30000000;

	public GoalRewardEvent() {
		super(GOAL_REWARD);
	}

	@Override
	public String getActionMessage() {
		return "ゴールしました。1番目にゴールしたので" + GOAL_REWARD + "円報酬としてもらいました。";
	}
}
