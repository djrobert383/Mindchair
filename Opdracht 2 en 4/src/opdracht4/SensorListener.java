package opdracht4;

public interface SensorListener {
	public void stateChanged(UpdatingSensor updatingSensor, float oldValue, float newValue);
}
