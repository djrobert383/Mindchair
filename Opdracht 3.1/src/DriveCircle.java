import lejos.nxt.Motor;

public class DriveCircle {

	private float wheelSpace;// afstand tussen de wielen in mm
	private float straal; // in mm
	private float tijd;//tijd om omwenteling te doen in seconden
	private float buitenOmtrek;
	private float binnenOmtrek;
	private float buitenSnelheid;
	private float binnenSnelheid;

	public DriveCircle(float wheelSpace, float straal, float tijd) {
		this.wheelSpace = wheelSpace;
		this.straal = straal;
		this.tijd=tijd;
		buitenOmtrek = (float) (2* Math.PI * straal);
		binnenOmtrek = buitenOmtrek - wheelSpace;
		//v = s/t
		buitenSnelheid = buitenOmtrek / tijd;
		binnenSnelheid = binnenOmtrek / tijd;
	}

	public void start() {
		Motor.A.setSpeed(binnenSnelheid);
		Motor.B.setSpeed(buitenSnelheid);
		Motor.A.forward();
		Motor.A.forward();
	}
}
