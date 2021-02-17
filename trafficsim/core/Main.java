package trafficsim.core;

public class Main {
	public static void main(String [] args){
		// get the singleton object of the traffic light manager
		TrafficLightManager trafficLightManager = TrafficLightManager.getTrafficManager();

		// Create the traffic light state machine


		// Set the traffic condition
		if (args.length > 0){
			System.out.println("Traffic Condition: " + args[0]);
			trafficLightManager.setTrafficCondition(args[0]);
			String s = args[0];
			TrafficLight.setTraffic(s);
			new TrafficLight(trafficLightManager);
		} else {
			new TrafficLight(trafficLightManager);
			System.out.println("Traffic Condition: <default>");
		}

	}
	

}
