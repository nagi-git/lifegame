package lifegame.event;

/**
 * イベントの子クラス<br>
 * ボーナスをもらうイベント
 * @author minami
 */
public class BonusEvent extends AbstractEvent {

	/** ボーナス金額 */
	private final static int BONUS = 1000000;

	/**
	 * コンストラクタ
	 */
	public BonusEvent() {
		super(BONUS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getActionMessage() {
		return "ボーナス" + BONUS + "円をもらいました。";
	}


}
