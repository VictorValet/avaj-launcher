import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) 
	{
		if (args.length == 0)
		{
			System.out.println("No scenario file");
			return ;
		}
		int					loops = 0;
		ArrayList<String[]>	lines = new ArrayList<String[]>();
		WeatherTower		tower = new WeatherTower();

		try {
			lines = Parser.parse(args[0]);
			loops = Integer.parseInt(lines.get(0)[0]);
			for (int i = 1; i < lines.size() - 1; i++)
			{
				// System.out.println(lines.get(i)[0] + " " + lines.get(i)[1] + " " +  Integer.parseInt(lines.get(i)[2]) + " " +  Integer.parseInt(lines.get(i)[3]) + " " +  Integer.parseInt(lines.get(i)[4]));
				AircraftFactory.newAircraft(lines.get(i)[0], lines.get(i)[1], new Coordinates(Integer.parseInt(lines.get(i)[2]), Integer.parseInt(lines.get(i)[3]), Integer.parseInt(lines.get(i)[4]))).registerTower(tower);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Error: " + args[0] + ": file not found");
			return ;
		}
		catch (IOException e){
			System.out.println("Error: " + args[0] + ": IO error");
			return ;
		}
		catch (AircraftFactoryException e){
			System.out.println("Error: " + e.s);
			return ;
		}

		//run loops till int loops == 0
	}
}
