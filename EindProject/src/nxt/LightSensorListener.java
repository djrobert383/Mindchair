package nxt;

/**
 * @author Robert
 * @version 0.2
 */
public interface LightSensorListener {
	public void lightSensorChanged(Position position,
			UpdatingSensor updatingsensor, float oldValue, float newValue);
}
