package lifegame.event;

import lifegame.Player;

public abstract class AbstractEvent {
	int depositAmount;

	protected AbstractEvent(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void processEvent(Player player) {
		System.out.println(this.getActionMessage());
		player.wallet.addMoney(depositAmount);
	}

	public abstract String getActionMessage();

}
