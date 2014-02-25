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
		System.out.println(wheelSpace);
		System.out.println(straal);
		System.out.println(tijd);
		System.out.println(buitenOmtrek);
		System.out.println(binnenOmtrek);
		System.out.println(buitenSnelheid);
		System.out.println(binnenSnelheid);
	}
}
