package it.unibo.es2;

import java.util.List;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	String hit(Pair<Integer,Integer> coords);
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
