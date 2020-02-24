package lifegame;

import java.util.ArrayList;
import java.util.List;

import lifegame.event.AbstractEvent;
import lifegame.event.BonusEvent;
import lifegame.event.BuyCarEvent;
import lifegame.event.BuyHouseEvent;
import lifegame.event.GoalRewardEvent;
import lifegame.event.LotteryEvent;

/**
 * すごろくボードのクラス
 */
public class SugorokuBoard {
	List<Cell> cells = new ArrayList<>();

	/**
	 * コンストラクタ
	 */
	public SugorokuBoard() {

		for (int i = 0; i <= 50; i++) {

			int cellNum = i;

			switch(cellNum) {
			case 3:
				AbstractEvent event = new LotteryEvent();
				cells.add(new Cell(event));
				break;
			case 13:
				event = new BuyCarEvent();
				cells.add(new Cell(event));
				break;
			case 23:
				event = new BonusEvent();
				cells.add(new Cell(event));
				break;
			case 33:
				event = new BuyHouseEvent();
				cells.add(new Cell(event));
				break;
			case 50:
				event = new GoalRewardEvent();
				cells.add(new Cell(event));
				break;
			default:
				// イベントなし
				cells.add(new Cell( null));
			}
		}
	}

	/**
	 * セルイベントメソッド
	 * (プレイヤーの進んだマス数のイベントを発生)
	 * @param player プレイヤー
	 * @param turnNumber ターン数
	 */
	public void callEvent(Player player, int turnNumber) {

		int totalDice = player.totalDice;

		Cell cell = this.cells.get(totalDice);

		AbstractEvent event = cell.getEvent();

		if(event != null) {
			// イベントがある場合は実行
			event.processEvent(player, turnNumber);
		}


	}
}
