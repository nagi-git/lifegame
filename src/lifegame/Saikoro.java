package lifegame;

import java.util.Random;

public class Saikoro {
	Random random = new Random();

	int dice() {
		return this.random.nextInt(6) + 1;
	}
}