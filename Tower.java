import java.util.ArrayList;

public class Tower{

	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable){
		observers.add(p_flyable);
		System.out.println("Tower says: " 
			+ ((Aircraft)p_flyable).toString() 
			+ " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable){
		int index = observers.indexOf(p_flyable);
		if (index != -1)
		{
			observers.remove(index);
			System.out.println("Tower says: " 
				+ ((Aircraft)p_flyable).toString()
				+ " unregistered from weather tower.");
		}
	}

	protected void conditionChanged(){
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
