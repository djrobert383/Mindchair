import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class Main implements ButtonListener {
	public static void main(String[] args){
		new Main();
	}
	
	public boolean nothingSelected=true;
	
	public Main(){
		options();
	}
	public void options(){
		clearScreen();
		System.out.println("Select Melody:");
		selection(true, "Melody 1");
		selection(false, "Melody 2");
		Button.LEFT.addButtonListener(this);
		Button.RIGHT.addButtonListener(this);
	}
	public void clearScreen(){
		for(int i=0; i<7;i++){
			System.out.println();
		}
	}
	public void selection(boolean selected,String text){
		clearScreen();
		if(selected){
			System.out.println(">"+text);
		}else{
			System.out.println(" "+text);			
		}
	}
	@Override
	public void buttonPressed(Button b) {
		clearScreen();
		System.out.println("Select Melody:");
		if(b.equals(Button.LEFT)){
			selection(true, "Melody 1");
			selection(false, "Melody 2");
		}
		if(b.equals(Button.RIGHT)){
			selection(false, "Melody 1");
			selection(true, "Melody 2");
		}
	}
	@Override
	public void buttonReleased(Button b) {
		
	}
}
