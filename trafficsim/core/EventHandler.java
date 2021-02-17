package trafficsim.core;

public interface EventHandler {

	public boolean timerYellow();
	public boolean timerGreen();
	public boolean moderateTraffic();
	public boolean lowTraffic();
	public boolean highTraffic();

}
