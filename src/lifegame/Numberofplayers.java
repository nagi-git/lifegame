package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numberofplayers {

	public static void main(String[] args) {
		SugorokuBoard sugorokuBoard = new SugorokuBoard();
		//number = ユーザーの入力したプレイヤー数
//		int number = inputPlayerNumber();
		int number = 2;
		System.out.println("プレイヤーの数を" + number + "人に設定しました。");
		System.out.println("");

		Saikoro saikoro = new Saikoro();

		Player[] players = new Player[number];
		for(int i = 1; i <= number; i++) {
			System.out.println("プレイヤー" + i + "の名前を入力してください。=>");
			Player player = new Player();
			System.out.println("プレイヤー" + i + "は" + player.name + "さんです。");
			System.out.println(player.name + "さんの職業は" + player.job.name() + "です。月に" + player.job.salary() + "円もらえます。");

			System.out.println("");

			players[i - 1] = player;
		}


		for(int i = 0; i < number; i++) {
			Player player = players[i];

			player.roll(saikoro);

			sugorokuBoard.callEvent(player);

			player.earnSalary();



			System.out.println("現在の所持金は" + player.wallet.toString() + "円です。");

// 			System.out.println(player.name + "さんが振った目の数は" + saikoro.dice + "です。");
//			System.out.println(player.name + "さんの現在のコマ数合計は" + player.totalDice + "です。");
//			System.out.println(player.name + "さんの現在の所持金は" + player.money + "円です。");
			enter();
		}
//		do {
//
//		} while(isEnd(rollNumber));
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

//	public static boolean isEnd(int rollNumber) {
//		if(rollNumber == 1 || rollNumber == 2 || ) {
//			return true;
//		}else {
//
//		}
//	}
}
