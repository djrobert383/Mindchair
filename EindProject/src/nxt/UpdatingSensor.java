package nxt;

public interface UpdatingSensor {
	/**
	 * Update the current state of a sensor
	 * 
	 */
	public void updateState();

	public SensorType getSensorType();
}
