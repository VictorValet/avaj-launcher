package project.avajlauncher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	private static FileWriter fw = null;

	private static final Logger	instance = new Logger();

	private Logger() {}

	public static void open(String file) throws IOException {
		fw = new FileWriter(file);
	}

	public static void log(String s) throws IOException {
		fw.write(s + "\n");
	}

	public static void close() throws IOException {
		fw.close();
	}
}
