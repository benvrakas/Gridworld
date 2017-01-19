import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Mover {
	private Actor me;
	private int steps;

	private final int view = 1000;

	public Mover(Actor me, int steps) {
		this.me = me;
		this.steps = steps;
	}

	public Location trackEnemy(int i) {
		return trackEntity(getClosest(see('n')),i);
		
	}

	public Location trackTeam(int i) {
		return trackEntity(getClosest(see('g')),i);
	}

	/*public Location VectorEnemy(int i) {

	}

	public Location VectorTeam(int i) {

	}

	public Location Escape();

	{

	}*/

	public double getDistTo(Location loc) {
		int x = loc.getCol();
		int y = loc.getRow();
		int myX = me.getLocation().getCol();
		int myY = me.getLocation().getRow();
		return Math.sqrt((y - myY) * (y - myY) + (x - myX) * (x - myX));
	}

	public Location trackEntity(Location ent, int dir) {
		Location meLoc = me.getLocation();
		for (int moves = steps; moves > 0; moves--) {
			meLoc = me.getLocation().getAdjacentLocation(meLoc.getDirectionToward(ent) + dir);
		}
		return meLoc;
	}

	public ArrayList<Location> see(char type) {
		Grid<Actor> grid = me.getGrid();
		ArrayList<Location> players = grid.getOccupiedLocations();
		Location meLoc = me.getLocation();
		ArrayList<Location> inVeiw = new ArrayList<Location>();
		if (type == 'n') {
			for (Location loc : players) {
				Actor you = grid.get(loc);
				if (!(meLoc.equals(loc)) && !(you instanceof Rock) && !(you instanceof Geek) && getDistTo(loc) < view) {
					inVeiw.add(loc);
				}
			}
		}
		if (type == 'g') {
			for (Location loc : players) {
				Actor you = grid.get(loc);
				if (!(meLoc.equals(loc)) && (you instanceof Geek) && getDistTo(loc) < view) {
					inVeiw.add(loc);
				}
			}
		}
		if (type == 'a') {
			for (Location loc : players) {
				Actor you = grid.get(loc);
				if (!(meLoc.equals(loc)) && !(you instanceof Rock) && getDistTo(loc) < view) {
					inVeiw.add(loc);
				}
			}
		}
		if (inVeiw.size() <= 1)
			return null;
		return inVeiw;
	}

	public Location getClosest(ArrayList<Location> locs) {
		double dist = view;
		Location closest = null;
		for (Location loc : locs) {
			if (getDistTo(loc) < dist) {
				closest = loc;
			}
		}
		return closest;
	}

	public Location threatVector()
	{
		return new Location(2,2);
	}
}