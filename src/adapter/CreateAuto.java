package adapter;

import model.Fleet;

public interface CreateAuto {
	public Fleet buildFleet(String fileName);
	public void printAuto(String Model);
}
