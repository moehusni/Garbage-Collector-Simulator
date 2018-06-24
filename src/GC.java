import java.util.LinkedList;
import java.util.Set;

abstract class GC 
{
	static boolean reachable ;
	private static LinkedList<Obj> objToRemove = new LinkedList<Obj>();

	static void mark() 
	{

		reachable = !reachable;
		Output.displayln("Mark phase started.");
		Output.displayln("The value of \"reachable\" variable changed " + reachable);
		Output.displayln("The following reachable objects visited by traversal.");
		Output.displayln("Display format is mark:objID:(description of object).\n");

		for (int i = RuntimeStack.topOfStack; i >= 0; i--) {
			RuntimeStack.runtimeStack[i].traverse();
		}
	}

	static void sweep() {
		Output.displayln("\nSweep phase started.");
		Output.displayln("The following allocated objects swept.");
		Output.displayln("Reachable objects are prefixed by +, unreachable objects by -.\n");
		int numUNreachable = 0;
		Set<String> keys = DataStorage.map.keySet();
		int numReachable = 0;

		for (String className : keys) {

			// storing the Linklist into a temperoray LinkedList called groupList
			LinkedList<Object> groupList = DataStorage.map.get(className);
			{
				for (int i=0; i < groupList.size();i++)
				{ 
					Obj obj = (Obj) groupList.get(i);
					if (obj.mark == GC.reachable) 
					{
						Output.displayln("+:" + obj);
						++numReachable;
					} 
					else 
					{
						Output.displayln("-:" + obj);
						++numUNreachable;
						objToRemove.add(obj);
					}
				} // while
			} 
		}
		
		Output.displayln("\n# of reachable objects = " + numReachable);
		Output.displayln("# of unreachable objects = " + numUNreachable + "\n");
		
		if(!objToRemove.isEmpty()) 
		{
		for (Obj obj : objToRemove) 
			DataStorage.deleteFrom(obj);
		
		objToRemove.clear();
		Output.displayln("The unreachable objects have been deleted from the data structure maintaining Obj objects.\n");
	
		}
	}

	static void gc() // invoke GC emulation
	{
		Output.displayln("-------------------------------------------------\n");
		Output.displayln("Mark-and-sweep GC emulation started.\n");
		mark();
		sweep();
	}

}
