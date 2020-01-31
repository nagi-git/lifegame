package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numberofplayers {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの数を入力する
		System.out.println("プレイヤーの数を入力 >");
		int number = Integer.parseInt(br.readLine()); //number = ユーザーの入力したプレイヤー数
		System.out.println("プレイヤーの数を" + number + "人に設定しました。");

		for(int i = 1; i < number; i++) {
			Player i = new Player(name, dice, money);
		}
	}
}
