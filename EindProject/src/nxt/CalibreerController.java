package nxt;

public class CalibreerController {
	
	
	private int _high;
	private int _low;
	
	public CalibreerController(){
	}
	
	public void calibreer(){
		MotorController.turnOnPlace(360);
		
	}

}
