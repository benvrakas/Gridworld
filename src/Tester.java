import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Tester 
{
	public static void main(String[] args)
	{
		World<Actor> w = new World<Actor>();
		w.add(new Location(0,0), new god());
		w.add(new Location(9,9), new god());
		w.show();
	}
}
