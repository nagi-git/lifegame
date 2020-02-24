package lifegame;

import lifegame.event.AbstractEvent;

/**
 * すごろくボードのマスを定義
 * @author minami
 */
public class Cell {

	/** セルで発生するイベント */
	private AbstractEvent event;

	/**
	 * コンストラクタ
	 * @param event セルで発生するイベント
	 */
	public Cell(AbstractEvent event) {
		this.event = event;
	}

	/**
	 * イベントを返す
	 */
	public AbstractEvent getEvent() {
		return event;
	}

}
