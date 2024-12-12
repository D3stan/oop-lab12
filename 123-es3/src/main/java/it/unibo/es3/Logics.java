package it.unibo.es3;

import java.awt.Point;
import java.util.List;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	List<Point> getNextCells();
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
