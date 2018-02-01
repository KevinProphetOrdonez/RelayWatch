
public class Timer {
	public static final long MILLIS_TO_MINUTES = 60000; 
	public static final long MILLIS_TO_HOURS = 3600000;
	
	private long startTime;
	
	boolean isRunning;
	
	
	public Timer() {
		
	}
	public void StopTimer() {
		isRunning = false;
	}
	public void StartTimer() {
		isRunning = true;
		startTime = System.currentTimeMillis() + 10000;
	}
	
	public void run() {
		while(isRunning) {
			long since = System.currentTimeMillis();
			
			int seconds = (int) (since / 1000) % 60;
			int minutess = (int) (since / MILLIS_TO_MINUTES) % 60;
			int hours = (int) (since / MILLIS_TO_HOURS) % 60;
		}
	}
}
