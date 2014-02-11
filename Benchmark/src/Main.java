import java.awt.Desktop;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;





public class Main {

	public static void main(String[] args) {
		systemInfo();
		benchmark(1);
		benchmark(5);
		benchmark(10);
		benchmark(20);
		benchmark(40);
		benchmark(80);

	}
	public static void benchmark(int amount){
		amount = amount*1000000;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<amount;i++){
			
			double random = (Math.cos(Math.sin(Math.random()/50*Math.random()))*Math.E)/Math.PI;
		}
		long endTime = System.currentTimeMillis();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		System.out.println("-------------------- "+amount+"x --------------------");
		System.out.println(endTime-startTime+" ms");
	}
	public static void systemInfo(){
		System.out.println("-------------------System Info--------------------");
		System.out.println("Os name: "+System.getProperty("os.name"));
		System.out.println("Os version: "+System.getProperty("os.version"));
		System.out.println("Amount of cores: "+Runtime.getRuntime().availableProcessors());
		System.out.println("Amount of memmory: "+Runtime.getRuntime().maxMemory());
		System.out.println("Free memmory: "+Runtime.getRuntime().freeMemory());
		System.out.println("--------------------------------------------------");
		System.out.println();
		
	}
}
