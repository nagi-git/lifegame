package lifegame;

import java.util.ArrayList;
import java.util.List;

import lifegame.event.AbstractEvent;
import lifegame.event.BonusEvent;
import lifegame.event.BuyCarEvent;
import lifegame.event.BuyHouseEvent;
import lifegame.event.GoalRewardEvent;
import lifegame.event.LotteryEvent;

public class SugorokuBoard {
	List<Cell> cells = new ArrayList<>();

	public SugorokuBoard() {

		for (int i = 0; i <= 50; i++) {

			int cellNum = i;

			switch(cellNum) {
			case 3:
				AbstractEvent event = new LotteryEvent();
				cells.add(new Cell(cellNum, event));
				break;
			case 13:
				event = new BuyCarEvent();
				cells.add(new Cell(cellNum, event));
				break;
			case 23:
				event = new BonusEvent();
				cells.add(new Cell(cellNum, event));
				break;
			case 33:
				event = new BuyHouseEvent();
				cells.add(new Cell(cellNum, event));
				break;
			case 50:
				event = new GoalRewardEvent();
				cells.add(new Cell(cellNum, event));
				break;
			default:
				cells.add(new Cell(cellNum, null));
			}
		}
	}

	public void callEvent(Player player, int turnNumber) {
//		this.cells.get(player.totalDice).getEvent().processEvent(player);

		int totalDice = player.totalDice;

		Cell cell = this.cells.get(totalDice);

		AbstractEvent event = cell.getEvent();

		if(event != null) {
			event.processEvent(player, turnNumber);
		}


	}
}
