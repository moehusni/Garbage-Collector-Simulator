abstract class Data extends Obj
{
	String IDcode; // the ID code of Data objects

	Data(String ID)
	{
		IDcode = ID;	
	}

	public String toString()
	{
		return super.toString() + ":" + IDcode;
	}

	void traverse()
	{
		this.mark = GC.reachable;
		Output.displayln(this.toString());	
	}
}