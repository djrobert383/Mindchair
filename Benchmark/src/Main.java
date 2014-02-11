import java.text.NumberFormat;

public class Main {
	public static int score;
	public static void main(String[] args) {
		benchmark(1);
		benchmark(5);
		benchmark(10);
		benchmark(20);
		benchmark(40);
		benchmark(80);
		benchmark(5);
		scoreCalc();
	}

	public static void benchmark(int amount) {
		long startTime = System.nanoTime();
		for (int i = 0; i < amount; i++) {

			double random = (Math.cos(Math.sin(Math.random() / 50
					* Math.random())) * Math.E)
					/ Math.PI;
		}
		long endTime = System.nanoTime();
		
		
		System.out.println("-------------------- " + amount
				+ "x --------------------");
		System.out.println(endTime - startTime + " nanoseconds");
		
		score+=(endTime - startTime);
	}
	public static void scoreCalc(){
		System.out.println();
		System.out.println("score:");
		System.out.println(score/10000);
	}
}
