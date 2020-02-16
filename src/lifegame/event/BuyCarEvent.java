package lifegame.event;

public class BuyCarEvent extends AbstractEvent {

	private final static int CARPRICE = -6000000;

	public BuyCarEvent() {
		super(CARPRICE);
	}

	@Override
	public String getActionMessage() {
		return "車を買ったので" + (- CARPRICE) + "円減りました。";
	}
}
