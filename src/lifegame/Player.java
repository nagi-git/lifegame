package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	String name;
	int totaldice;
	int money;

	Player () {
		this.name = inputName();

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
		int rollNumber = saikoro.dice();
		System.out.println(this.name + "さんがサイコロを振りました。");
		System.out.println(rollNumber);
		return rollNumber;
	}
}
