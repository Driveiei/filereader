import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileByBufferedReader implements Runnable {

	private int size;
	private static String filename;

	public ReadFileByBufferedReader(String filename) {
		this.filename = filename;
	}

	public static String readFileByBufferedReader() {
		String text = "";
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(filename));
			String line = buffer.readLine();
			while (line != null) {
				text = text + line + "\n";
				line = buffer.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (buffer != null) {
			try {
				buffer.close();
			} catch (IOException e) {
				/* ignore it */
			}
		}
		return text;
	}

	@Override
	public void run() {
		size = readFileByBufferedReader().length();
	}

	@Override
	public String toString() {
		return String.format("Read %s and append lines to String \nwith %d chars ", filename, size);
	}
}
