package lifegame;

import lifegame.event.AbstractEvent;

public class Cell {


	private int cellNum;
	private AbstractEvent event;

	public Cell(int cellNum, AbstractEvent event) {
		this.cellNum = cellNum;
		this.event = event;
	}

	public AbstractEvent getEvent() {
		return event;
	}

}
