package lifegame;

import java.util.Random;

/**
 * 仕事の列挙子
 * @author minami
 */
public enum Job {
	野球選手(1000000),
	タレント(500000),
	会社員(300000),
	社長(10000000),
	アルバイト(150000),
	医者(600000);

	/** 給料 */
    private int salary;

    /**
     * コンストラクタ
     * @param salary 給料
     */
    private Job(int salary) {
        this.salary = salary;
    }

    /**
     * 仕事を選ぶメソッド
     * @param salary 給料
     * @return 仕事
     */
	public static Job jobChoice() {
		Job[] jobs = Job.values();

		Random random = new Random();

		// id = ランダムな整数
		int id = random.nextInt(jobs.length);

		return jobs[id];
	}

	/**
	 * 給料を返す
	 * @return 給料
	 */
	public int salary() {
		return this.salary;
	}
}
