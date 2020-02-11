package lifegame.event;

public class BuyHouseEvent extends AbstractEvent {

	private final static int HOUSEPRICE = -20000000;

	public BuyHouseEvent() {
		super(HOUSEPRICE);
	}

	@Override
	public String getActionMessage() {
		return "家を買ったので" + (- HOUSEPRICE) + "円減りました。";
	}
}
