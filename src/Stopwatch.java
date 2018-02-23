public class Stopwatch {

	private long startTime;
	private long endTime;
	private boolean running;
	private static final double NANOSECOND = 1.0E-9;

	public Stopwatch() {
		startTime = 0;
		endTime = 0;
		running = false;
	}

	public void start() {
		if (running)
			return;
		startTime = System.nanoTime();
		running = true;
	}

	public void stop() {
		if (!running)
			return;
		endTime = System.nanoTime();
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public double getElapsed() {
		if (isRunning()) {
			return (System.nanoTime() - startTime) * NANOSECOND;
		} else {
			return (endTime - startTime) * NANOSECOND;
		}
	}

}
