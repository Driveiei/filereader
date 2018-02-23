
public class Main {

	public static void main(String[] args) {
		String text = "src/Alice-in-Wonderland.txt";
		TaskTimer task = new TaskTimer();
		task.measureAndPrint(new ReadFileToString(text));
		TaskTimer tasker = new TaskTimer();
		tasker.measureAndPrint(new ReadFileToStringBuilder(text));
		TaskTimer taskered = new TaskTimer();
		taskered.measureAndPrint(new ReadFileByBufferedReader(text));
	}

}
