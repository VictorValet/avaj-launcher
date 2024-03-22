package project.avajlauncher;

import java.io.IOException;
import java.util.ArrayList;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable) throws IOException {
		observers.add(p_flyable);
		Logger.log("Tower says: " 
			+ ((Aircraft)p_flyable).toString() 
			+ " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable) throws IOException {
		int index = observers.indexOf(p_flyable);
		if (index != -1)
		{
			observers.remove(index);
			Logger.log("Tower says: " 
				+ ((Aircraft)p_flyable).toString()
				+ " unregistered from weather tower.");
		}
	}

	protected void conditionChanged() throws IOException {
		int size = observers.size();
		for (int i = 0; i < size; i++)
		{
			observers.get(i).updateConditions();
			if (observers.size() < size)
			{
				i--;
				size--;
			}
		}
	}
}
