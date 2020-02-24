package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * lifegameの実行
 * @author minami
 */

public class LifegamePlay {

	/** すごろくボード */
	private final static SugorokuBoard SUGOROKU_BOARD = new SugorokuBoard();

	/** サイコロ */
	private final static Saikoro SAIKORO = new Saikoro();

	public static void main(String[] args) {

		List<Player> players = initialize();

		// player全員がゴールするまでlifegameのターンを繰り返す
		for(int i = 1; !isFinished(players); i++) {
			System.out.println( "【" + i + "回目のターン】\n");

			for(Player player : players) {
				if (isFinished(player)){
					continue;
				}
				player.roll(SAIKORO);

				player.earnSalary();

				SUGOROKU_BOARD.callEvent(player, i);

				System.out.println("現在の所持金は" + player.getWallet().toString() + "円です。");

				enter();
			}
		}

		rankWallet(players);
		System.out.println("\n---lifegameを終了します---\nプレイしてくれてありがとうございました！！");

	}

	private static List<Player> initialize() {
		System.out.println("lifegameをスタートします。\n" + SugorokuBoard.MAX_TOTAL_DICE + "マスに達したらゴールです！\n");

		int number = inputPlayerNumber();
		System.out.println("プレイヤーの数を" + number + "人に設定しました。\n");

		List<Player> players = new ArrayList<>();

		for(int i = 1; i <= number; i++) {
			Player player = new Player(i);
			players.add(player);
		}

		return players;
	}

	/**
	 * ユーザーにplayerの名前を入力する指示を出すメソッド
	 * @return ユーザーが入力した値
	 */
	private static int inputPlayerNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの数を入力する
		System.out.println("プレイヤーの数(半角数字)を入力してください。=>");
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("プレイヤーの数(半角数字)を入力してください。=>");
			return inputPlayerNumber();
		}
	}

	/**
	 *ユーザーにエンターキーを押す指示を出すメソッド
	 */
	private static void enter() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nエンターキーを押してください。=>");
		try {
			br.readLine();
		} catch (NumberFormatException | IOException e) {
		}
	}

	/**
	 * ゴールに到達したかどうかを返す
	 * @param player プレイヤー
	 * @return ゴールに到達したら{@code true}
	 */
	private static boolean isFinished(Player player) {
		if (player.getTotalDice() >= SugorokuBoard.MAX_TOTAL_DICE) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * player全員がゴールに到達したかどうかを返す
	 * @param players 全プレイヤーのリスト
	 * @return 全員がゴールに到達したら{@code true}
	 */
	private static boolean isFinished(List<Player> players) {
		for (Player player : players) {
			if(player.getTotalDice() < SugorokuBoard.MAX_TOTAL_DICE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 合計金額の順位を出す
	 * @param players 全プレイヤーのリスト
	 */
	private static void rankWallet(List<Player> players) {

		players.sort(
			new Comparator<Player>() {

				/**
				 * プレイヤーの比較方法を定義
				 * @param player1 プレイヤー1
				 * @param player2 プレイヤー2
				 * @return 最初のプレイヤーの所持金がが2番目のプレイヤーの所持金より小さい場合は負の整数、
				 *          両方が等しい場合は0、
				 *          最初のプレイヤーの所持金が2番目のプレイヤーの所持金より大きい場合は正の整数を返します。
				 */
				@Override
				public int compare(Player player1, Player player2) {
					if(player1.getWallet().getMoney() < player2.getWallet().getMoney()) {
						return 1;
					} else if (player1.getWallet().getMoney() > player2.getWallet().getMoney()) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		);

		System.out.println("◆順位結果◆");
		for(int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			System.out.println(i + 1 + "位: " + player.getName() + "さん " + player.getWallet() + "円");
		}
	}
}
