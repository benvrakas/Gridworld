import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Tester 
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Grid<Actor> grid = new BoundedGrid<Actor>(50, 50);
		world.setGrid(grid);
		world.add(new Location(25,25), new KnightBugGeek());
		world.add(new Location(29,29), new Rock());
		
	/*	world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());
		world.add(new Location((int)(Math.random()*50),(int)(Math.random()*50)), new Critter());*/
		world.show();
	}
}
