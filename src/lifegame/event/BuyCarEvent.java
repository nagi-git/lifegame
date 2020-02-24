package lifegame.event;

/**
 * イベントの子クラス<br>
 * 車を買うイベント
 * @author minami
 */
public class BuyCarEvent extends AbstractEvent {

	/** 車の金額 */
	private final static int CARPRICE = -6000000;

	/**
	 * コンストラクタ
	 */
	public BuyCarEvent() {
		super(CARPRICE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getActionMessage() {
		return "車を買ったので" + (- CARPRICE) + "円減りました。";
	}
}
