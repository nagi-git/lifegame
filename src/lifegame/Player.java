package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	String name;
	int dice;
	int money;

	Player (String name, int dice, int money) {
		this.name = name;
		this.dice = dice;
		this.money = money;
	}

	void inputName()throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの名前を入力する
		System.out.println("名前を入力 >");
		this.name = br.readLine(); //プレイヤーの名前
	}
}
