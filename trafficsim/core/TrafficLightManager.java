package trafficsim.core;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import trafficsim.gui.TrafficLightAnimation;
import trafficsim.gui.TrafficLightUserInterface;

public class TrafficLightManager extends EventGenerator {

	private static TrafficLightManager trafficLightManager;

	private TrafficLightUserInterface trafficLightUI;

	private static final int TIMER_GREEN_PERIOD = 3000;
	private static final int TIMER_YELLOW_PERIOD = 1000;

	private TrafficTimer timer;

	/**
	 * This methods implement the singleton pattern by allowing only a single
	 * instance of this class to be created
	 * @return TrafficLightManager instance
	 */
	public static TrafficLightManager getTrafficManager(){
		if (trafficLightManager == null){
			trafficLightManager = new TrafficLightManager();
		}
		return trafficLightManager;
	}


	private TrafficLightManager (){
		super();
		// Create the animation frame
		trafficLightUI = new TrafficLightAnimation();

		JFrame win = new JFrame("Traffic Light");
		win.setSize(800, 600);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		win.add((TrafficLightAnimation)trafficLightUI);
		win.setVisible(true);

		timer = new TrafficTimer();


	}


	public void setTrafficCondition(String trafficCondition){
		// Create and send an even regarding the traffic condition
		if (trafficCondition.equalsIgnoreCase("lowTraffic")){
			sendEvent(TRAFFIC_LOW_EVENT);
		}
		else if (trafficCondition.equalsIgnoreCase("moderateTraffic")){
			sendEvent(TRAFFIC_MODERATE_EVENT);
		}
		else if (trafficCondition.equalsIgnoreCase("highTraffic")){
			sendEvent(TRAFFIC_HIGH_EVENT);
		}
	}



	/**
	 * Sends an event to all listening event handlers
	 */
	@Override
	protected void sendEvent(int eventID) {


		for (EventHandler handler: eventHandlers){
			switch (eventID){
				case TIMER_YELLOW_EVENT: handler.timerYellow();
				break;
				case TIMER_GREEN_EVENT: handler.timerGreen();
				break;
				case TRAFFIC_LOW_EVENT: handler.lowTraffic();
				break;
				case TRAFFIC_MODERATE_EVENT: handler.moderateTraffic();
				break;
				case TRAFFIC_HIGH_EVENT: handler.highTraffic();
				break;
			}
		}

	}

	/**
	 * Schedule a timer for the traffic signal if one is not already scheduled
	 */
	private void scheduleTimer(int timerType) {
		if (!timer.isScheduled()) {

			int period;
			if (timerType == TIMER_YELLOW_EVENT)
				period = TIMER_YELLOW_PERIOD;
			else
				period = TIMER_GREEN_PERIOD;

			timer.scheduleTrafficTimer(new TrafficTimerTask(timerType), period);
		}
	}


	/**
	 * Methods to control the animation of the traffic light
	 */
	public void northGreen(){
		trafficLightUI.northGreen();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void northArrow(){
		trafficLightUI.northArrow();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void northGreenAndArrow(){
		 trafficLightUI.northGreenAndArrow();
		 scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void northYellow(){
		trafficLightUI.northYellow();
		scheduleTimer(TIMER_YELLOW_EVENT);
	}

	public void northRed(){
		trafficLightUI.northRed();
	}



	public void southGreen(){
		trafficLightUI.southGreen();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void southArrow(){
		trafficLightUI.southArrow();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void southGreenAndArrow(){
		 trafficLightUI.southGreenAndArrow();
		 scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void southYellow(){
		trafficLightUI.southYellow();
		scheduleTimer(TIMER_YELLOW_EVENT);
	}

	public void southRed(){
		trafficLightUI.southRed();
	}


	public void westGreen(){
		trafficLightUI.westGreen();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void westArrow(){
		trafficLightUI.westArrow();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void westGreenAndArrow(){
		trafficLightUI.westGreenAndArrow();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void westYellow(){
		trafficLightUI.westYellow();
		scheduleTimer(TIMER_YELLOW_EVENT);
	}

	public void westRed(){
		trafficLightUI.westRed();
	}


	public void eastGreen(){
		trafficLightUI.eastGreen();
		scheduleTimer(TIMER_GREEN_EVENT);
	}
	public void eastArrow(){
		trafficLightUI.eastArrow();
		scheduleTimer(TIMER_GREEN_EVENT);
	}

	public void eastGreenAndArrow(){
		trafficLightUI.eastGreenAndArrow();
		scheduleTimer(TIMER_GREEN_EVENT);
	}
	public void eastYellow(){
		trafficLightUI.eastYellow();
		scheduleTimer(TIMER_YELLOW_EVENT);
	}

	public void eastRed(){
		trafficLightUI.eastRed();
	}



	/*************************************/




	private class TrafficTimer extends Timer{

		TrafficTimerTask task;



		public void scheduleTrafficTimer(TrafficTimerTask task, int period) {
			this.task = task;
			super.schedule(task, period);

			task.setScheduled(true);

		}

		private boolean isScheduled() {
			if (task == null)
				return false;

			return task.isScheduled();
		}
	}

	private class TrafficTimerTask extends TimerTask{

		private int timerType;

		private boolean scheduled;
		private TrafficTimerTask (int timerType) {
			this.timerType = timerType;

			setScheduled(false);
		}

		@Override
		public void run() {
			setScheduled(false);
			sendEvent(timerType);



		}



		private void setScheduled(boolean scheduled) {
			this.scheduled = scheduled;


		}

		private boolean isScheduled() {
			return scheduled;
		}

	}
}
