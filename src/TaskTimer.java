/**
 * A TaskTimer runs a task using a Stopwatch and prints the elapsed time.
 * 
 * @author Kornphon Noiprasert
 */
public class TaskTimer {

	/**
	 * Using a Stopwatch and prints the elapsed time.
	 * 
	 * @param runnable is specific tasks that wanted to measure.
	 */
	public static void measureAndPrint(Runnable runnable) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.print(runnable.toString());
		System.out.printf("in %.6f secs.\n", sw.getElapsed());
	}
}