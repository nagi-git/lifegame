package lifegame.event;

import lifegame.Player;

public abstract class AbstractEvent {
	int depositAmount;

	protected AbstractEvent(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void processEvent(Player player, int turnNumber) {
		System.out.println(this.getActionMessage());
		player.getWallet().addMoney(depositAmount);
	}

	public String getActionMessage() {
		return "";
	}

}
