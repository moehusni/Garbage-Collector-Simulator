class EmptyBST<C extends Data> extends BST<C>

// The class of empty binary search trees.

{
	void traverse() 
	{
		this.mark = GC.reachable;
		Output.displayln(this.toString());
	}
}
