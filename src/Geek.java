import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Geek extends SuperBug {
	/**
	 * array list that holds all actors on the grid. Updated by the
	 * <code>updateActors()</code> method
	 */

	public Geek() 
	{
		super();
	}
	/**
	 * Returns the actors on the current grid
	 * 
	 * @return ArrayList of actors
	 */
	public ArrayList<Actor> getActorsOnGrid() {

		ArrayList<Actor> actors = new ArrayList<Actor>();
		if(getGrid() != null)
		{
		ArrayList<Location> locs = getGrid().getOccupiedLocations();
		for (Location l : locs) {
			if (l != null && actors != null) {
				actors.add((Actor) getGrid().get(l));
			}
		}
		}
		return actors;
	}

	/**
	 * Gives distance from current location to supplied location
	 * 
	 * @param loc
	 * @return the distance to the given location
	 */
	public double getDistanceTo(Location loc) {
		int x = loc.getCol();
		int y = loc.getRow();

		int myX = this.getLocation().getCol();
		int myY = this.getLocation().getRow();

		double distance = Math.sqrt((y - myY) * (y - myY) + (x - myX) * (x - myX));
		return distance;
	}

}