import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

//USE THIS ONE – FINAL VERSION 1.0
public class SuperBug extends Critter
{
	private boolean hasBred;
	
	private boolean alive;
	private boolean frozen;
	private boolean poisoned;
	
	private int poisonCount;
	private int freezeCount;
	
	
	public SuperBug()
	{
		alive = true;
		frozen = false;
		poisoned = false;
		hasBred = false;
		freezeCount = -1;
		poisonCount = -1;
	}
	
	public void kill() //You may override as needed, but don't cheat! 
	{
		alive = false;
		removeSelfFromGrid();
		
	}
	
	public void poison(int howLong)
	{
		if(!poisoned)
		{
			poisoned = true;
			poisonCount = howLong;
		}	
	}
	
	public void resurrect()
	{
		alive = true;
		frozen = false;
		poisoned = false;
		hasBred = true;
		freezeCount = -1;
		poisonCount = -1;
	}
	public void heal()
	{
		poisoned = false;
		poisonCount = -1;
	}
	public void freeze(int howLong)
	{
		if(!frozen)
		{
			frozen = true;
			freezeCount = howLong;

		}
	}
	public void thaw()
	{
		frozen = false;
		freezeCount = -1;

	}
	
	public boolean canBeKilled()  // Ghost overrides
	{
		return true;
	}
	
	public void breed()
	{
		if(!hasBred)
		{
			int i = (int)  (Math.random() * 10);
			if(i == 1)
			{
				hasBred = true;
				cloneSelf();
			}		
		}
		else return;
	}
	
	public void cloneSelf() // Override
	{
		SuperBug child = new SuperBug(); // swap out bug type for SuperBug
		child.isOffspring();
		ArrayList<Location> cribs = super.getMoveLocations();
		Location putYourKidHere = super.selectMoveLocation(cribs);
		child.putSelfInGrid(getGrid(), putYourKidHere);
	}
	
	public void isOffspring()
	{
		hasBred = true;
	}
	
	public void duel(SuperBug other) //please override
	{
		
	}
	public void checkTimers() 
	{
		if(frozen) freezeCount--;
		if(poisoned) poisonCount--;
		if(poisonCount < 1 && poisoned) 
		{ 
			this.kill(); 
			poisoned = false;
			poisonCount = -1;
		}
		if(freezeCount < 1 && frozen) 
		{
			this.thaw();
			frozen = false;
			freezeCount = -1;
		}
	}
	public void act()
	{
		checkTimers();		
		if(!frozen)
			{
				super.act();
				breed();		
			}
	}
	
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof SuperBug)
                duel((SuperBug) a);
        }
    }
	
	public boolean checkFrozen() { return frozen; }
	public boolean checkAlive() { return alive; }
	public boolean checkPoisoned() { return poisoned; }

	public String toString()
	{
		return super.toString() + ", alive=" + alive + ", frozen=" + frozen + ", poizoned=" + poisoned + ", freezeCount=" + freezeCount + ", poisonCount=" + poisonCount + ", hasBred=" + hasBred + "]";
	}
	
}
