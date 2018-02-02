

public class Main {
	
	public static void  main(String args[]) {
		// TODO Auto-generated constructor stub
		System.out.println("RelayWatch initiating...");
		Display display = new Display();
		Timer timer = new Timer(display);
		
		timer.StartTimer();
	}
}