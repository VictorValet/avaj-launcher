package project.avajlauncher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	private static final Parser	instance = new Parser();

	private Parser() {}

	public static ArrayList<String[]> parse(String file) throws FileNotFoundException, IOException {
		ArrayList<String[]> lines = new ArrayList<>();
		String[]			line;
		String				buffer;
		int					n = 0;

		BufferedReader br = new BufferedReader(new FileReader(file));
		buffer = br.readLine();
		while (buffer != null) {
			line = buffer.split(" ");
			if ((n == 0 && line.length != 1) || (n != 0 && line.length != 5))
				throw (new NumberFormatException());
			lines.add(line);
			buffer = br.readLine();
			n++;
		}
		br.close();
		return (lines);
	}
}
