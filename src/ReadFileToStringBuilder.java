import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileToStringBuilder implements Runnable{

	private static String filename;
	private int size;
	
	public ReadFileToStringBuilder(String filename) {
		this.filename = filename;
	}

	public static String readFileToStringBuilder() {
		StringBuilder data = new StringBuilder();// change
		String name = filename;
		InputStream in = null;
		try {
			in = new FileInputStream(filename);// read as characters
			InputStreamReader reader = new InputStreamReader(in); // read the file
			while (true) {
				int c = reader.read();
				if (c < 0)
					break;
				data = data.append((char) c);// change
			} 
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				/* ignore it */
			}
		}
		return data.toString();// change
	}

	@Override
	public void run() {
		size = readFileToStringBuilder().length();
	}
	
	@Override
	public String toString() {
		return String.format("Read %s and append to a StringBuilder \nwith %d chars",filename,size);
	}
}
