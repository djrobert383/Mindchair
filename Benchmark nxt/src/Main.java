import lejos.nxt.Button;

public class Main {
	public static int score;

	public static void main(String[] args) {
		benchmark(1);
		benchmark(5);
		benchmark(10);
		benchmark(20);
		benchmark(40);
		benchmark(80);
		scoreCalc();
	}

	public static void benchmark(int amount) {
		System.out.println();
		long startTime = System.nanoTime();
		for (int i = 0; i < amount; i++) {

			double random = (Math.cos(Math.sin(Math.random() / 50
					* Math.random())) * Math.E)
					/ Math.PI;
		}
		long endTime = System.nanoTime();
		System.out.println(amount + "x");
		System.out.println(endTime - startTime + " ns");
		System.out.println("press enter");
		score += (endTime - startTime);
		Button.ENTER.waitForPress();

	}

	public static void scoreCalc() {
		System.out.println();
		System.out.println("score:");
		System.out.println(score / 10000);
		System.out.println("press escape");
		Button.ESCAPE.waitForPress();
	}

}
