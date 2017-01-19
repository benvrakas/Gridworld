import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class KnightBugGeek extends Geek {
	private Mover m = new Mover(this, 1);
	
	KnightBugGeek()
	{
		setColor(Color.RED);
	}
	
	public void act() {
		
		if (getGrid() == null)
			return;
		
		if (m.see('n') != null)
			moveTo(m.trackEnemy(0));
		else {
			ArrayList<Actor> actors = getActors();
			processActors(actors);
			 ArrayList<Location> moveLocs = getMoveLocations();
		     Location loc = selectMoveLocation(moveLocs);
		     makeMove(loc);
		}
	}

	public void cloneSelf() {
		KnightBugGeek child = new KnightBugGeek();
		child.setColor(null);
		child.isOffspring();
		ArrayList<Location> cribs = super.getMoveLocations();
		Location putYourKidHere = super.selectMoveLocation(cribs);
		child.putSelfInGrid(getGrid(), putYourKidHere);
	}
}
