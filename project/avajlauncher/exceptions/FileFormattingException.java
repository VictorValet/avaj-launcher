package project.avajlauncher.exceptions;

public class FileFormattingException extends Exception {

	String[]	line;
	Integer		lineNumber;

	public FileFormattingException(
		String[]	p_line,
		Integer		p_lineNumber
	) {
		line = p_line;
		lineNumber = p_lineNumber;
	}

	public String lineToString() {
		if (line == null || lineNumber == null) {
			return ("empty file");
		}
		StringBuilder s = new StringBuilder();
		for (String word : line) {
			s.append(word).append(" ");
		}
		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}
		return (
			"at line " + lineNumber +
			": " + s.toString()
		);
	}
}
