

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskTimer {

	public static String readFile1(String filename) {
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

	public static String readFile2(String filename) {
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

	public static String readFile3(String filename) {
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

	public static void main(String[] args) {
		// create a stopwatch
		String text = "src/Alice-in-Wonderland.txt";
		Stopwatch sw = new Stopwatch();
		// start the stopwatch
		
		System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to String.");
		sw.start();
		String alice = readFile1(text);
		// stop the stopwatch
		sw.stop();
		// print the result
		System.out.printf("Read %d chars in %.6f sec.\n", alice.length(), sw.getElapsed());
		
		System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder.");
		sw.start();
		 String alice2 = readFile2(text);
		sw.stop();
		 System.out.printf("Read %d chars in %.6f sec.\n", alice2.length(),sw.getElapsed());

		System.out.println("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.");
		sw.start();
		String alice3 = readFile3(text);
		sw.stop();
		System.out.printf("Read %d chars in %.6f sec.\n", alice3.length(),sw.getElapsed());

	}
}