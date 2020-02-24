package lifegame;

import java.util.Random;

/**
 * サイコロのクラス
 * @author minami
 */
public class Saikoro {

	/** 乱数ジェネレータ */
	Random random = new Random();

	/**
	 * 1～6の乱数を発生する
	 */
	int randomNumber() {
		return this.random.nextInt(6) + 1;
	}
}