package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	String name;
	int totalDice;
	int money;

	Player () {
		this.name = inputName();
		this.totalDice = 0;
		this.money = 10000;
	}

	String inputName() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの名前を入力する
		try {

			return br.readLine(); //プレイヤーの名前
		} catch (IOException e) {
			e.printStackTrace();
			return inputName();
		}
	}

	int roll(Saikoro saikoro) {
		int rollNumber = saikoro.randomNumber();
		System.out.println(this.name + "さんがサイコロを振りました。");
		System.out.println("サイコロの目は" + rollNumber + "でした。");
		return rollNumber;
	}

	int addDice(int dice) {
		this.totalDice += dice;
		System.out.println(this.name + "さんの現在のコマ数合計は" + this.totalDice + "です。");
		return this.totalDice;
	}

}
