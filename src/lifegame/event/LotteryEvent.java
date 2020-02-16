package lifegame.event;

public class LotteryEvent extends AbstractEvent {

	private final static int WINNINGS = 10000000;

	public LotteryEvent() {
		super(WINNINGS);
	}

	@Override
	public String getActionMessage() {
		return "宝くじが当たり" + WINNINGS + "円をもらいました。";
	}

}
