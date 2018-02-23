import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileToString implements Runnable{

	private static String filename;
	private int size;

	public ReadFileToString(String filename) {
		this.filename = filename;
	}

	public static String readFileToString() {
		String data = "";
		InputStream in = null;
		try {
			in = new FileInputStream(filename);// read as characters
			InputStreamReader reader = new InputStreamReader(in); // read the file
			while (true) {
				int c = reader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				/* ignore it */
			}
		}
		return data;
	}	
	
	@Override
	public void run() {
		size = readFileToString().length();
	}
	
	@Override
	public String toString() {
		return String.format("Read %s and append to a String \nwith %d chars",filename,size);
	}

}
