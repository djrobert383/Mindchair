package nxt;

public interface UltraSonicSensorListener {
	/**
	 * 
	 * @param us
	 *            the UltrasonicSensor that has been changed
	 * @param oldValue
	 *            the value before the change
	 * @param newValue
	 *            the value after it has been changed
	 */
	public void ultraSonicChanged(UpdatingSensor us, float oldValue,
			float newValue);
}
