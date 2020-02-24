package lifegame.event;

/**
 * AbstractEventの子クラス<br>
 * 宝くじをもらうイベント
 * @author minami
 */
public class LotteryEvent extends AbstractEvent {

	/** 宝くじの当選金額 */
	private final static int WINNINGS = 10000000;

	/**
	 * コンストラクタ
	 */	public LotteryEvent() {
		super(WINNINGS);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	protected String getActionMessage() {
		return "宝くじが当たり" + WINNINGS + "円をもらいました。";
	}

}
