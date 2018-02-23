/**
 * A Main class to create objects and connect objects together to show runtime
 * by reading Alice-in-Wonderland.txt.
 * 
 * @author Kornphon Noiprasert
 */
public class Main {

	/**
	 * Configure and check the runtime.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		String text = "src/Alice-in-Wonderland.txt";
		Runnable[] tasks = { new ReadFileToString(text), new ReadFileToStringBuilder(text),
				new ReadFileByBufferedReader(text) };
		TaskTimer.measureAndPrint(tasks[0]);
		TaskTimer.measureAndPrint(tasks[1]);
		TaskTimer.measureAndPrint(tasks[2]);
	}

}
