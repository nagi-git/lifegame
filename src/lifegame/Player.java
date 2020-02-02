package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	String name;
	int dice;
	int money;

	Player () {
		this.name = inputName();
		this.dice = 0;
		this.money = 10000;
	}

	String inputName() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの名前を入力する
		try {
			System.out.println("名前を入力 >");
			return br.readLine(); //プレイヤーの名前
		} catch (IOException e) {
			e.printStackTrace();
			return inputName();
		}
	}



}
