import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Timer {
	public static final long MILLIS_TO_MINUTES = 60000; //Constant used to calculate miliseconds to minutes 
	public static final long MILLIS_TO_HOURS = 3600000; //Constant used to calculate miliseconds to hours
	
	private long CountDownTime; //Long to store the time the user wants to stop at
	private LinkedList<Integer> countDowns; //Linked list containing the countdowns the user wants
	Iterator<Integer> countDownTracker; //Iterator will be used to run all countdowns until linked list is empty
	
	private Display display; //Reference to Parent class
	boolean isRunning; //Flag used to start and stop timer
	
	
	public Timer(Display parent, LinkedList<Integer> userCountDowns) { //constructer saved parent reference
		display = parent; 
		countDowns = userCountDowns; //Linked list containing user count downs
		countDownTracker = countDowns.iterator();// iterator to traverse the linked list
		
	}
	public void StopTimer() {//Method used to change flag and in turn stop the timer
		isRunning = false;
	}
	public void StartTimer() { //Method used to change flag and in turn start the timer
		isRunning = true;
		CountDownTime = System.currentTimeMillis() + countDownTracker.next(); //Returns the next count down in the list
		run();
	}
	public void NextCountDown() {
		System.out.println("Starting next Count Down...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CountDownTime = System.currentTimeMillis() + countDownTracker.next();
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
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(hours == 0 && minutes == 0 && seconds == 0) {
				if(countDownTracker.hasNext())
				{
					NextCountDown();
				}else {
					StopTimer();
				}
				
			}
			
		}
	
	}
}
