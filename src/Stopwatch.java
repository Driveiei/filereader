/**
 * A Stopwatch class computes elapsed time between a start and stop time.
 * 
 * @author Kornphon Noiprasert
 */
public class Stopwatch {

	/** attribute for the starting time. */
	private long startTime;
	/** attribute for the ending time. */
	private long endTime;
	/** attribute for checking if the program is running. */
	private boolean running;
	/** attribute for compute the time in nanosecond. */
	private static final double NANOSECOND = 1.0E-9;

	/**
	 * Initialize a time to process the program.
	 */
	public Stopwatch() {
		startTime = 0;
		endTime = 0;
		running = false;
	}

	/**
	 * Starting the count time when program start.
	 */
	public void start() {
		if (running)
			return;
		startTime = System.nanoTime();
		running = true;
	}

	/**
	 * Ending the count time when program end.
	 */
	public void stop() {
		if (!running)
			return;
		endTime = System.nanoTime();
		running = false;
	}

	/**
	 * Get the status of program that's running or not.
	 * 
	 * @return the status of program that's running or not.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Get the time by computes elapsed time between a start and stop time.
	 * 
	 * @return Elapsed time between a start and stop time.
	 */
	public double getElapsed() {
		if (isRunning()) {
			return (System.nanoTime() - startTime) * NANOSECOND;
		} else {
			return (endTime - startTime) * NANOSECOND;
		}
	}

}
