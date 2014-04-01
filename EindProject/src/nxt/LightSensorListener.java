package nxt;

public interface LightSensorListener {
	public enum Position {
		Left, Right;
	}

	public void lightSensorChanged(LightSensorListener.Position position,
			UpdatingSensor updatingsensor, float oldValue, float newValue);
}
