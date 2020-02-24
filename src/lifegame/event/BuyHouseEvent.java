package lifegame.event;

/**
 * イベントの子クラス<br>
 * 家を買うイベント
 * @author minami
 */
public class BuyHouseEvent extends AbstractEvent {

	/** 家の金額 */
	private final static int HOUSEPRICE = -20000000;

	/**
	 * コンストラクタ
	 */
	public BuyHouseEvent() {
		super(HOUSEPRICE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getActionMessage() {
		return "家を買ったので" + (- HOUSEPRICE) + "円減りました。";
	}
}
