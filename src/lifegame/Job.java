package lifegame;

import java.util.Random;

public enum Job {
	野球選手(1000000),
	タレント(500000),
	会社員(300000),
	社長(10000000),
	アルバイト(150000),
	医者(600000);

    // フィールドの定義
    private int salary;

    // コンストラクタの定義
    private Job(int salary) {
        this.salary = salary;
    }

	public static Job jobChoice() {
		Job[] jobs = Job.values(); //変数jobsにJobの配列を入れている

		Random random = new Random();

		int id = random.nextInt(jobs.length);

		return jobs[id];
	}

	public int salary() {
		return this.salary;
	}
}
