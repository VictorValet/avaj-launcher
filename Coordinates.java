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
		height = p_height;
		if (p_height > 100)
			p_height = 100;
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
