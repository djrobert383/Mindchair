package nxt;

public interface LightSensorListener {
	/**
	 * @author Robert
	 * @version 0.2
	 */
	public void lightSensorChanged(Position position,
			UpdatingSensor updatingsensor, float oldValue, float newValue);
}
