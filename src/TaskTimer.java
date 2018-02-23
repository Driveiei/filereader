
public class TaskTimer {

	public static void measureAndPrint(Runnable runnable) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.print(runnable.toString());
		System.out.printf("in %.6f secs.\n", sw.getElapsed());
	}
}