package lifegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * プレイヤークラス
 * @author minami
 */
public class Player {

	/** 名前 */
	private String name;

	/** 現在のマス目 */
	private int totalDice;

	/** 所持金を入れる財布 */
	private Wallet wallet;

	/** 職業 */
	private Job job;

	/**
	 * コンストラクタ
	 * @param playerNumber プレイヤーの通し番号
	 */
	public Player(int playerNumber) {
		this.name = inputName(playerNumber);
		this.totalDice = 0;
		this.wallet = new Wallet(10000);
		this.job = Job.jobChoice();

		System.out.println("プレイヤー" + playerNumber + "は" + this.name + "さんです。");
		System.out.println(this.name + "さんの職業は" + this.job.name() + "です。月に" + this.job.salary() + "円もらえます。\n");
	}

	/**
	 * 名前を取得
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 現在のマス目を取得
	 * @return 現在のマス目
	 */
	public int getTotalDice() {
		return totalDice;
	}

	/**
	 * 財布を取得
	 * @return 財布
	 */
	public Wallet getWallet() {
		return wallet;
	}

	/**
	 * 標準入力よりプレイヤー名の入力を指示する。
	 * @param playerNumber プレイヤーの通し番号
	 * @return 入力したプレイヤー名
	 */
	private String inputName(int playerNumber) {
		System.out.println("プレイヤー" + playerNumber + "の名前を入力してください。=>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの名前を入力する
		try {
			return br.readLine(); //プレイヤーの名前
		} catch (IOException e) {
			return inputName(playerNumber);
		}
	}

	/**
	 * サイコロを振る
	 * @param saikoro サイコロの目
	 * @return totalDice 現在のマス目
	 */
	public int roll(Saikoro saikoro) {
		int rollNumber = saikoro.randomNumber();
		System.out.println(this.name + "さんがサイコロを振りました。");
		System.out.println("サイコロの目は" + rollNumber + "でした。");

		if((this.totalDice + rollNumber) >= SugorokuBoard.MAX_TOTAL_DICE) {
			this.totalDice = SugorokuBoard.MAX_TOTAL_DICE;
		} else {
			this.totalDice += rollNumber;
		}
		System.out.println("現在のマス目は" + this.totalDice + "です。");
		return this.totalDice;
	}

	/**
	 * 職業に応じた給料を財布に入れる
	 */
	public void earnSalary() {
		this.wallet.addMoney(this.job.salary());
		System.out.println(this.job.name() + "のお給料" + this.job.salary() + "円をもらいました。");
	}

}
