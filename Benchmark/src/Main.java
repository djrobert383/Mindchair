import java.text.NumberFormat;

public class Main {
	public static int score;
	public static void main(String[] args) {
/*		benchmark(1);
		benchmark(5);
		benchmark(10);
		benchmark(20);
		benchmark(40);*/
		benchmark(80000);
		//scoreCalc();
	}

	public static void benchmark(long amount) {
		amount = amount*10000;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < amount; i++) {

			double random = (Math.cos(Math.sin(Math.random() / 50
					* Math.random())) * Math.E)
					/ Math.PI;
		}
		long endTime = System.currentTimeMillis();
		NumberFormat nf = NumberFormat.getInstance();
		
		System.out.println("-------------------- " + nf.format(amount)
				+ "x --------------------");
		System.out.println(endTime - startTime + " ms");
		
		score+=(endTime - startTime);
	}
	public static void scoreCalc(){
		System.out.println();
		System.out.println("score:");
		System.out.println(score/10000);
	}
}
