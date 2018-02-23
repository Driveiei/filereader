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
		String all = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while (line != null) {
				all = all + line + "\n";
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				/* ignore it */
			}
		}
		return all;
	}

	@Override
	public void run() {
		size = readFileByBufferedReader().length();
	}
	
	@Override
	public String toString() {
		return String.format("Read %s and append lines to String \nwith %d chars",filename,size);
	}
}
