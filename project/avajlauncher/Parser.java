package project.avajlauncher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import project.avajlauncher.exceptions.FileFormattingException;

public class Parser {

	private static final Parser	instance = new Parser();

	private Parser() {}

	public static LinkedHashMap<Integer, String[]> parse(
		String file
	) throws FileFormattingException, IOException {
		LinkedHashMap<Integer, String[]>	lines = new LinkedHashMap<>();
		String[]							line;
		String								buffer;
		int									i = 1;

		BufferedReader br = new BufferedReader(new FileReader(file));
		buffer = br.readLine();
		while (buffer != null) {
			if (!buffer.isEmpty()) {
				line = buffer.split(" ");
				if ((lines.size() == 0 && line.length != 1)
					|| (lines.size() != 0 && line.length != 5)) {
					throw new FileFormattingException(line, i);
				}
				lines.put(i, line);
			}
			buffer = br.readLine();
			i++;
		}
		if (lines.size() == 0) {
			throw new FileFormattingException(null, null);
		}
		br.close();
		return (lines);
	}
}
