import java.util.Date;





public class Main {

	public static void main(String[] args) {
		Benchmark();
		Benchmark();
		Benchmark();
		Benchmark();
		Benchmark();
		Benchmark();

	}
	public static void Benchmark(){
		Date date = new Date();
		long time1=date.getTime();
		for(int i=0;i<10000000;i++){
			
			double random = (Math.cos(Math.sin(Math.random()/50*Math.random()))*Math.E)/Math.PI;
		}
		date = new Date();
		long time2=date.getTime();
		System.out.println("---------------------------------------------");
		System.out.println(time2-time1+" ms");
	}
}
