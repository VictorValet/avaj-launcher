public class Coordinates{
	
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(){
		longitude = 0;
		latitude = 0;
		height = 0;
	}

	Coordinates(int p_longitude, int p_latitude, int p_height){
		longitude = p_longitude;
		latitude = p_latitude;
		if (p_height > 100)
			height = 100;
		else
			height = p_height;
	}

	public int getLongitude(){
		return (longitude);
	}

	public int getLatitude(){
		return (latitude);
	}

	public int getHeight(){
		return (height);
	}
}
