import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Mover {
	private Actor me;
	private int steps;

	private final int view = 15;

	public Mover(Actor me, int steps) {
		this.me = me;
		this.steps = steps;
	}

	public Location trackEnemy(int i) {
		return trackLoc(getClosest(see('n')), i);

	}

	public Location trackTeam(int i) {
		return trackLoc(getClosest(see('g')), i);
	}

	public Location vectorEnemy(int i) {
		return trackLoc(vectorAvg(see('n')), i);
	}

	public Location vectorTeam(int i) {
		return trackLoc(vectorAvg(see('n')), i);
	}

	public double getDistTo(Location loc) {
		int x = loc.getCol();
		int y = loc.getRow();
		int myX = me.getLocation().getCol();
		int myY = me.getLocation().getRow();
		return Math.sqrt((y - myY) * (y - myY) + (x - myX) * (x - myX));
	}

	public Location trackLoc(Location ent, int dir) {
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
		if (inVeiw.size() == 0)
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

	public Location vectorAvg(ArrayList<Location> locs) {
		double i = 0;
		double r = 0;
		double c = 0;
		for (Location loc : locs) {
			double threat = view - getDistTo(loc);
			r += threat * loc.getRow();
			c += threat * loc.getCol();
			i += threat;
		}
		return new Location((int)(Math.round(r / i)), (int)Math.round(c / i));
	}
}