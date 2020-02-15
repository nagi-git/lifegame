package lifegame;

public class Player {

	private static String[] NAMES = new String[] {"MMM", "RRR"};
	private static int COUNT = -1;


	String name;
	int totalDice;
	public Wallet wallet;
	Job job;

	Player () {
		this.name = inputName();
		this.totalDice = 0;
		this.wallet = new Wallet(10000);
		this.job = Job.jobChoice();
	}

	String inputName() {
		COUNT++;
		return NAMES[COUNT];
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ユーザーがプレイヤーの名前を入力する
//		try {
//
//			return br.readLine(); //プレイヤーの名前
//		} catch (IOException e) {
//			e.printStackTrace();
//			return inputName();
//		}
	}

	int roll(Saikoro saikoro) {
		int rollNumber = saikoro.randomNumber();
		System.out.println(this.name + "さんがサイコロを振りました。");
		System.out.println("サイコロの目は" + rollNumber + "でした。");

		if((this.totalDice + rollNumber) >= 50 ) {
			this.totalDice = 50;
		} else {
			this.totalDice += rollNumber;
		}
		System.out.println("現在のコマ数合計は" + this.totalDice + "です。");
		return this.totalDice;
	}



	public void earnSalary() {
		this.wallet.addMoney(this.job.salary());
		System.out.println(this.job.name() + "のお給料" + this.job.salary() + "円をもらいました。");
	}

}
