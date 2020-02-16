package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Numberofplayers {

	private final static int TOTAL_DICE = 50;

	public static void main(String[] args) {
		SugorokuBoard sugorokuBoard = new SugorokuBoard();
		//number = ユーザーの入力したプレイヤー数
//		int number = inputPlayerNumber();
		int number = 2;
		System.out.println("プレイヤーの数を" + number + "人に設定しました。");
		System.out.println("");

		Saikoro saikoro = new Saikoro();

		List<Player> players = new ArrayList<>();
		for(int i = 1; i <= number; i++) {
			System.out.println("プレイヤー" + i + "の名前を入力してください。=>");
			Player player = new Player();
			System.out.println("プレイヤー" + i + "は" + player.name + "さんです。");
			System.out.println(player.name + "さんの職業は" + player.job.name() + "です。月に" + player.job.salary() + "円もらえます。");

			System.out.println("");

			players.add(player);
		}

		for(int i = 1; !isEnd(players); i++) {
			System.out.println( i + "回目のターンです");
			for(Player player : players) {
				if (isEnd(player.totalDice)){
					continue;
				}
				player.roll(saikoro);

				player.earnSalary();

				sugorokuBoard.callEvent(player, i);

				System.out.println("現在の所持金は" + player.wallet.toString() + "円です。");

				if (isEnd(player.totalDice)){

					enter();
					continue;
				}

				enter();
			}
		}
	}

	public static int inputPlayerNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの数を入力する
		System.out.println("プレイヤーの数(半角数字)を入力してください。=>");
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
			System.out.println("プレイヤーの数(半角数字)を入力してください。=>");
			return inputPlayerNumber();
		}
	}

	public static void enter() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの数を入力する
		System.out.println("エンターキーを押してください。");
		try {
			br.readLine();
		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
		}
	}

	public static boolean isEnd(int totalDice) {
		if(totalDice >= TOTAL_DICE ) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEnd(List<Player> players) {
		for (Player player : players) {
			if(player.totalDice < TOTAL_DICE) {
				return false;
			}
		}
		return true;
	}
}
