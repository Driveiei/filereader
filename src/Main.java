
public class Main {

	public static void main(String[] args) {
		String text = "src/Alice-in-Wonderland.txt";
		Runnable[] tasks = { new ReadFileToString(text),
				new ReadFileToStringBuilder(text),
				new ReadFileByBufferedReader(text)};
		TaskTimer.measureAndPrint(tasks[0]);
		TaskTimer.measureAndPrint(tasks[1]);
		TaskTimer.measureAndPrint(tasks[2]);
	}

}
