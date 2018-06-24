public abstract class MainGCtest
{
	public static void main(String argv[])
	{
		// argv[0]: output file

		Output.setOutput( argv[0] );

		AR_BST_test ar = new AR_BST_test();

		RuntimeStack.push(ar);
		ar.BST_test();
		RuntimeStack.pop();

		// All Obj objects have become unreachable.

		GC.gc();

		// No Obj objects exist.

		GC.gc();

		Output.closeOutput();
	}
} 
