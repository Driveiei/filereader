import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A ReadFileByBufferedReader class read file line at a time using
 * BufferedReader by reading Alice-in-Wonderland.txt.
 * 
 * @author Kornphon Noiprasert
 */
public class ReadFileByBufferedReader implements Runnable {

	/** attribute for counting the alphabets of file */
	private int size;
	/** attribute is the position of a file to reading in this class. */
	private static String filename;

	/**
	 * Initialize a filename to process.
	 * 
	 * @param filename
	 *            is the location of file.
	 */
	public ReadFileByBufferedReader(String filename) {
		this.filename = filename;
	}

	/**
	 * Reading the file each line at a time per one time and collect into a text by
	 * BufferedReader, and String.
	 * 
	 * @return the text of file.
	 * @throw IOException - signals that an I/O exception of some sort has occurred.
	 *        Catching the general class of exceptions produced by failed or
	 *        interrupted I/O operations
	 */
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

	/**
	 * To starting reading the file by BufferedReader and collecting the number of
	 * characters in this text.
	 */
	@Override
	public void run() {
		size = readFileByBufferedReader().length();
	}

	/**
	 * toString describes the position of filename and the number of characters in
	 * this text..
	 * 
	 * @return description of this text.
	 */
	@Override
	public String toString() {
		return String.format("Read %s and append lines to String \nwith %d chars ", filename, size);
	}
}
