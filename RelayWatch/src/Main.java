
import java.util.LinkedList;

public class Main {
	
	public static void  main(String args[]) {
		// TODO Auto-generated constructor stub
		System.out.println("RelayWatch initiating...");
		LinkedList<Integer> userCountDowns = new LinkedList(); //Arraylist with the countdown the user wants 
		userCountDowns.add(1000);
		userCountDowns.add(2000);
		userCountDowns.add(3000);
		
		
		Display display = new Display();
		Timer timer = new Timer(display, userCountDowns);
		
		timer.StartTimer();
	}
}