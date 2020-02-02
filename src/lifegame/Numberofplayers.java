package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numberofplayers {

	public static void main(String[] args) {

		//number = ユーザーの入力したプレイヤー数
		int number = inputPlayerNumber();
		System.out.println("プレイヤーの数を" + number + "人に設定しました。");

		for(int i = 1; i <= number; i++) {
			Player player = new Player();
			System.out.println("プレイヤー" + i + "の名前は" + player.name + "です。");
			System.out.println("プレイヤー" + i + "の現在のコマ数は" + player.dice + "です。");
			System.out.println("プレイヤー" + i + "の現在の所持金は" + player.money + "です。");
		}
	}

	public static int inputPlayerNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの数を入力する
		System.out.println("プレイヤーの数(半角数字)を入力してください。 >");
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
			System.out.println("プレイヤーの数(半角数字)を入力してください。 >");
			return inputPlayerNumber();
		}
	}
}
