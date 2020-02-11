package lifegame.event;

public class BonusEvent extends AbstractEvent {

	private final static int BONUS = 1000000;

	public BonusEvent() {
		super(BONUS);
	}

	@Override
	public String getActionMessage() {
		return "ボーナス" + BONUS + "円をもらいました。";
	}


}
