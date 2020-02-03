package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numberofplayers {

	public static void main(String[] args) {

		//number = ユーザーの入力したプレイヤー数
		int number = inputPlayerNumber();
		System.out.println("プレイヤーの数を" + number + "人に設定しました。");
		System.out.println("");

 		Saikoro saikoro = new Saikoro();

		Player[] players = new Player[number];
		for(int i = 1; i <= number; i++) {
			System.out.println("プレイヤー" + i + "の名前を入力してください。=>");
			Player player = new Player();
			System.out.println("プレイヤー" + i + "は" + player.name + "さんです。");
 			System.out.println(player.name + "さんが振った目の数は" + saikoro.dice + "です。");
			System.out.println(player.name + "さんの現在のコマ数合計は" + player.totaldice + "です。");
			System.out.println(player.name + "さんの現在の所持金は" + player.money + "円です。");
			System.out.println("");

			players[i - 1] = player;
		}

		do {
			for(int i = 0; i < number; i++) {
				Player player = players[i];
 				player.roll();
			}
		} while(true);
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
}
