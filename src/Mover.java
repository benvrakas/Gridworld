package teamBugs;

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

	public Location moveEnemy(int i)
	{

	}

	public Location moveTeam(int i) {

	}

	public Location moveDoctor(int i) {

	}

	public Location VectorEnemy(int i) {

	}

	public Location VectorTeam(int i) {

	}

	public double getDistTo(Location loc) {
		int x = loc.getCol();
		int y = loc.getRow();
		int myX = me.getLocation().getCol();
		int myY = me.getLocation().getRow();
		return Math.sqrt((y - myY) * (y - myY) + (x - myX) * (x - myX));
	}

	public Location moveToEntity(int dir, Actor bug) {
		int realdir = (me.getLocation().getDirectionToward(bug.getLocation()))

		+ dir;
		return me.getLocation().getAdjacentLocation(realdir);
	}

	public ArrayList<Location> GetVisEnemies() {
		Grid<Actor> grid = me.getGrid();
		ArrayList<Location> players = grid.getOccupiedLocations();
		ArrayList<Location> enemies = new ArrayList<Location>();
		for (Location loc : players) {
			Actor you = grid.get(loc);
			if (!(you instanceof Rock) && !(you instanceof Geek) && getDistTo(loc) < view) {
				enemies.add(loc);
			}
		}
		return enemies;
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
}