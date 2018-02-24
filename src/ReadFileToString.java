import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A ReadFileToString class read file 1-char at a time to String by reading
 * Alice-in-Wonderland.txt.
 * 
 * @author Kornphon Noiprasert
 */
public class ReadFileToString implements Runnable {

	/** attribute is the position of a file to reading in this class. */
	private static String filename;
	/** attribute for counting the alphabets of file */
	private int size;

	/**
	 * Initialize a filename to process.
	 * 
	 * @param filename
	 *            is the location of file.
	 */
	public ReadFileToString(String filename) {
		this.filename = filename;
	}

	/**
	 * Reading the file each one character per one time and collect into a text by
	 * InputStream, InputStreamReader, and String.
	 * 
	 * @return the text of file.
	 * @throw IOException - signals that an I/O exception of some sort has occurred.
	 *        Catching the general class of exceptions produced by failed or
	 *        interrupted I/O operations
	 */
	public static String readFileToString() {
		String text = "";
		InputStream in = null;
		try {
			in = new FileInputStream(filename); // read as characters
			InputStreamReader reader = new InputStreamReader(in); // read the file
			while (true) {
				int character = reader.read();
				if (character < 0)
					break;
				text = text + (char) character;
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
		return text;
	}

	/**
	 * To starting reading the file by InputStream and InputStreamReader and
	 * collecting the number of characters in this text.
	 */
	@Override
	public void run() {
		size = readFileToString().length();
	}

	/**
	 * toString describes the position of filename and the number of characters in
	 * this text.
	 * 
	 * @return description of this text.
	 */
	@Override
	public String toString() {
		return String.format("Read %s and append to a String \nwith %d chars ", filename, size);
	}

}
