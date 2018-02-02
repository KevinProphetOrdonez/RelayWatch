
public class Timer {
	public static final long MILLIS_TO_MINUTES = 60000; 
	public static final long MILLIS_TO_HOURS = 3600000;
	
	private long CountDownTime;
	private Display display;
	boolean isRunning;
	
	
	public Timer(Display parent) {
		display = parent;
	}
	public void StopTimer() {
		isRunning = false;
	}
	public void StartTimer() {
		isRunning = true;
		CountDownTime = System.currentTimeMillis() + 10000;
		run();
	}
	
	public void run() {
		while(isRunning) {
			long since = CountDownTime - System.currentTimeMillis();
			
			int seconds = (int) (since / 1000) % 60;
			int minutes = (int) (since / MILLIS_TO_MINUTES) % 60;
			int hours = (int) (since / MILLIS_TO_HOURS) % 60;
			
			String time = String.format("%02d:%02d:%02d", hours,minutes,seconds);
			display.updateCountDown(time);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(hours == 0 && minutes == 0 && seconds == 0) {
				StopTimer();
			}
			
			
		}
	}
}
