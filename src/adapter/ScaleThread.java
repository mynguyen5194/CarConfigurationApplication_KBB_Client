package adapter;

public interface ScaleThread {
	public void updateModelName(String oldModelName, String newModelName);
	public void updateOptionName(String Model, String oldName, String newName);
	public void updateOptionPrice(String Model, String Name, double newPrice);
}
