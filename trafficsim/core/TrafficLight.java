package trafficsim.core;



/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 2 "model.ump"
// line 178 "model.ump"
// line 183 "model.ump"
// line 188 "model.ump"
// line 193 "model.ump"
public class TrafficLight implements EventHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  public enum State { StatehighTraffic, StatemoderateTraffic, StatelowTraffic }
  public enum StateHighTraffic {northArrowH, northYellowH, northRedH, southYellowH, southRedH, westGreenH, eastAndWestYellowH }
  public enum StateModerateTraffic { northYellow, northRed, southYellow, southRed, eastAndWestYellow, northArrowAndGreen }
  public enum StateLowTraffic {northAndSouthArrowGreen, northAndSouthArrow, northAndSouthYellow, northAndSouthRed, westAndEastYellow }
  private State state;
  private StateHighTraffic stateHighTraffic;
  private StateModerateTraffic stateModerateTraffic;
  private StateLowTraffic stateLowTraffic;
  private TrafficLightManager trafficLightManager;
  public static String traffic;
   // CONSTRUCTOR
  //------------------------

	public static String getTraffic() {
		return traffic;
	}
	public static void setTraffic(String tra) {
		TrafficLight.traffic = tra;
	}
  public TrafficLight(TrafficLightManager aTrafficLightManager)
  {
	    trafficLightManager = aTrafficLightManager;
	    if(TrafficLight.getTraffic().equalsIgnoreCase("highTraffic")) {
	    	 setState(State.StatehighTraffic);
	    	 setStateHighTraffic(StateHighTraffic.northArrowH);
	    	
	    }
	    else if (TrafficLight.getTraffic().equalsIgnoreCase("lowTraffic")) {
	    	
	    	 setState(State.StatelowTraffic);
	    	    setStateLowTraffic(StateLowTraffic.northAndSouthArrowGreen);
	    }
	    else if(TrafficLight.getTraffic().equalsIgnoreCase("moderateTraffic")) {
	    	
	    	setState(State.StatemoderateTraffic);
	    	  setStateModerateTraffic(StateModerateTraffic.northArrowAndGreen);
	    	
	    }
	   
	    // line 11 "../../TrafficLight.ump"
	    trafficLightManager.addEventHandler(this);
	    // END OF UMPLE AFTER INJECTION
  }

  //------------------------
  // INTERFACE
  //------------------------


  public boolean setTrafficLightManager(TrafficLightManager aTrafficLightManager)
  {
    boolean wasSet = false;
    trafficLightManager = aTrafficLightManager;
    wasSet = true;
    return wasSet;
  }

  public TrafficLightManager getTrafficLightManager()
  {
    return trafficLightManager;
  }

  public String getStatusFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getStatus()
  {
    return state;
  }


  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    State astate = state;
    if(astate == State.StatehighTraffic ) {
    	
    	 StateHighTraffic StateHighTraffic = stateHighTraffic;
    switch(StateHighTraffic) {
    case northArrowH:
        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.northYellowH);
        wasEventProcessed = true;
        break;
      case northRedH:
        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.southYellowH);
        wasEventProcessed = true;
        break;
      case southRedH:
        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.westGreenH);
        wasEventProcessed = true;
        break;
      case westGreenH:
        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.eastAndWestYellowH);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }
    }
    else if(astate == State.StatemoderateTraffic) {
    	
    	  StateModerateTraffic StateModerateTraffic = stateModerateTraffic;
    	  switch (StateModerateTraffic)
    	    {
    	      case northArrowAndGreen:
    	        setStateModerateTraffic(trafficsim.core.TrafficLight.StateModerateTraffic.northYellow);
    	        wasEventProcessed = true;
    	        break;
    	      case northRed:
    	        setStateModerateTraffic(trafficsim.core.TrafficLight.StateModerateTraffic.southYellow);
    	        wasEventProcessed = true;
    	        break;
    	      case southRed:
    	        setStateModerateTraffic(trafficsim.core.TrafficLight.StateModerateTraffic.eastAndWestYellow);
    	        wasEventProcessed = true;
    	        break;
    	      default:
    	        // Other states do respond to this event
    	    }


    }
    else if(astate == State.StatelowTraffic) {
    	
    	StateLowTraffic StateLowTraffic = stateLowTraffic;
        switch (StateLowTraffic)
    {
      case northAndSouthArrowGreen:
        setStateLowTraffic(trafficsim.core.TrafficLight.StateLowTraffic.northAndSouthArrow);
        wasEventProcessed = true;
        break;
      case northAndSouthArrow:
        setStateLowTraffic(trafficsim.core.TrafficLight.StateLowTraffic.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case northAndSouthRed:
        setStateLowTraffic(trafficsim.core.TrafficLight.StateLowTraffic.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }
    }
    
     



    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    State astate = state;
    if(astate == State.StatehighTraffic ) {
    	
    	 StateHighTraffic StateHighTraffic = stateHighTraffic;
    	    switch (StateHighTraffic)
    	    {
    	      case northYellowH:
    	        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.northRedH);
    	        wasEventProcessed = true;
    	        break;
    	      case southYellowH:
    	        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.southRedH);
    	        wasEventProcessed = true;
    	        break;
    	      case eastAndWestYellowH:
    	        setStateHighTraffic(trafficsim.core.TrafficLight.StateHighTraffic.northArrowH);
    	        wasEventProcessed = true;
    	        break;
    	      default:
    	        // Other states do respond to this event
    	    }
    }
    else if(astate == State.StatemoderateTraffic) {
    	
    	  StateModerateTraffic StateModerateTraffic = stateModerateTraffic;
    	  switch (StateModerateTraffic)
    	    {
    	    case northYellow:
    	        setStateModerateTraffic(trafficsim.core.TrafficLight.StateModerateTraffic.northRed);
    	        wasEventProcessed = true;
    	        break;
    	      case southYellow:
    	        setStateModerateTraffic(trafficsim.core.TrafficLight.StateModerateTraffic.southRed);
    	        wasEventProcessed = true;
    	        break;
    	      case eastAndWestYellow:
    	        setStateModerateTraffic(trafficsim.core.TrafficLight.StateModerateTraffic.northArrowAndGreen);
    	        wasEventProcessed = true;
    	        break;
    	      default:
    	        // Other states do respond to this event
    	        // Other states do respond to this event
    	    }


    }
    else if(astate == State.StatelowTraffic) {
    	
    	StateLowTraffic StateLowTraffic = stateLowTraffic;
        switch (StateLowTraffic)
    {
    case northAndSouthYellow:
        setStateLowTraffic(trafficsim.core.TrafficLight.StateLowTraffic.northAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        setStateLowTraffic(trafficsim.core.TrafficLight.StateLowTraffic.northAndSouthArrowGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }
    }
    


    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;
    // entry actions and do activities
    switch(state)
    {
      case StatehighTraffic:
        if (stateHighTraffic == StateHighTraffic.northArrowH) { setStateHighTraffic(StateHighTraffic.northArrowH); }
        break;
      case StatemoderateTraffic:
        if (stateModerateTraffic == StateModerateTraffic.northArrowAndGreen) { setStateModerateTraffic(StateModerateTraffic.northArrowAndGreen); }
        break;
      case StatelowTraffic:
        if (stateLowTraffic == StateLowTraffic.northAndSouthArrowGreen) { setStateLowTraffic(StateLowTraffic.northAndSouthArrowGreen); }
        break;
    }
  }

  private void setStateHighTraffic(StateHighTraffic aStateHighTraffic)
  {
    stateHighTraffic = aStateHighTraffic;
    // entry actions and do activities
    switch(stateHighTraffic)
    {
      case northArrowH:
        // line 6 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 7 "model.ump"
        trafficLightManager.southRed();
        // line 8 "model.ump"
        trafficLightManager.westRed();
        // line 9 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellowH:
        // line 14 "model.ump"
        trafficLightManager.northYellow();
        // line 15 "model.ump"
        trafficLightManager.southRed();
        // line 16 "model.ump"
        trafficLightManager.westRed();
        // line 17 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northRedH:
        // line 23 "model.ump"
        trafficLightManager.northRed();
        // line 24 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 25 "model.ump"
        trafficLightManager.westRed();
        // line 26 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellowH:
        // line 30 "model.ump"
        trafficLightManager.southYellow();
        // line 31 "model.ump"
        trafficLightManager.northRed();
        // line 32 "model.ump"
        trafficLightManager.eastRed();
        // line 33 "model.ump"
        trafficLightManager.westRed();
        break;
      case southRedH:
        // line 39 "model.ump"
        trafficLightManager.southRed();
        // line 40 "model.ump"
        trafficLightManager.westArrow() ;
        // line 41 "model.ump"
        trafficLightManager.westGreen();
        // line 42 "model.ump"
        trafficLightManager.northRed();
        // line 43 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westGreenH:
        // line 49 "model.ump"
        trafficLightManager.westGreen();
        // line 50 "model.ump"
        trafficLightManager.eastGreen();
        // line 51 "model.ump"
        trafficLightManager.northRed();
        // line 52 "model.ump"
        trafficLightManager.southRed();
        break;
      case eastAndWestYellowH:
        // line 58 "model.ump"
        trafficLightManager.westYellow();
        // line 59 "model.ump"
        trafficLightManager.eastYellow();
        // line 60 "model.ump"
        trafficLightManager.northRed();
        // line 61 "model.ump"
        trafficLightManager.southRed();
        break;
	default:
		break;
    }
  }

  private void setStateModerateTraffic(StateModerateTraffic aStateModerateTraffic)
  {
    stateModerateTraffic = aStateModerateTraffic;
   
    // entry actions and do activities
    switch(stateModerateTraffic)
    {
      case northArrowAndGreen:
        // line 72 "model.ump"
        trafficLightManager.northGreenAndArrow() ;
        // line 73 "model.ump"
        trafficLightManager.southRed() ;
        // line 74 "model.ump"
        trafficLightManager.westRed() ;
        // line 75 "model.ump"
        trafficLightManager.eastRed() ;
        break;
      case northYellow:
        // line 80 "model.ump"
        trafficLightManager.northYellow() ;
        // line 81 "model.ump"
        trafficLightManager.southRed() ;
        // line 82 "model.ump"
        trafficLightManager.westRed() ;
        // line 83 "model.ump"
        trafficLightManager.eastRed() ;
        break;
      case northRed:
        // line 88 "model.ump"
        trafficLightManager.northRed() ;
        // line 89 "model.ump"
        trafficLightManager.southGreenAndArrow() ;
        // line 90 "model.ump"
        trafficLightManager.westRed() ;
        // line 91 "model.ump"
        trafficLightManager.eastRed() ;
        break;
      case southYellow:
        // line 97 "model.ump"
        trafficLightManager.northRed() ;
        // line 98 "model.ump"
        trafficLightManager.southYellow();
        // line 99 "model.ump"
        trafficLightManager.eastRed();
        // line 100 "model.ump"
        trafficLightManager.westRed();
        break;
      case southRed:
        // line 105 "model.ump"
        trafficLightManager.northRed() ;
        // line 106 "model.ump"
        trafficLightManager.southRed() ;
        // line 107 "model.ump"
        trafficLightManager.westGreen() ;
        // line 108 "model.ump"
        trafficLightManager.eastGreen() ;
        break;
      case eastAndWestYellow:
        // line 116 "model.ump"
        trafficLightManager.northRed() ;
        // line 117 "model.ump"
        trafficLightManager.southRed() ;
        // line 118 "model.ump"
        trafficLightManager.eastYellow() ;
        // line 119 "model.ump"
        trafficLightManager.westYellow() ;
        break;
	default:
		break;
    }
  }

  private void setStateLowTraffic(StateLowTraffic aStateLowTraffic)
  {
    stateLowTraffic = aStateLowTraffic;
   
    // entry actions and do activities
    switch(stateLowTraffic)
    {
      case northAndSouthArrowGreen:
        // line 132 "model.ump"
        trafficLightManager.northArrow();
        // line 133 "model.ump"
        trafficLightManager.southArrow();
        // line 134 "model.ump"
        trafficLightManager.westRed();
        // line 135 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthArrow:
        // line 139 "model.ump"
        trafficLightManager.northGreen();
        // line 140 "model.ump"
        trafficLightManager.southGreen();
        // line 141 "model.ump"
        trafficLightManager.westRed();
        // line 142 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 146 "model.ump"
        trafficLightManager.northYellow();
        // line 147 "model.ump"
        trafficLightManager.southYellow();
        // line 148 "model.ump"
        trafficLightManager.westRed();
        // line 149 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        // line 153 "model.ump"
        trafficLightManager.northRed();
        // line 154 "model.ump"
        trafficLightManager.southRed();
        // line 155 "model.ump"
        trafficLightManager.westGreen();
        // line 156 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 161 "model.ump"
        trafficLightManager.northRed();
        // line 162 "model.ump"
        trafficLightManager.southRed();
        // line 163 "model.ump"
        trafficLightManager.westYellow();
        // line 164 "model.ump"
        trafficLightManager.eastYellow();
        break;
	default:
		break;
    }
  }

  public void delete()
  {}


public boolean moderateTraffic() {
	timerYellow();
	timerGreen();
	return false;
}

@Override
public boolean lowTraffic() {
	timerYellow();
	timerGreen();
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean highTraffic() {
	timerYellow();
	timerGreen();
	// TODO Auto-generated method stub
	return false;
}

}