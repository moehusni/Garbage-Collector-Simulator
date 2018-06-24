class ARsearch<C extends Data> extends AR {
	BST<C> target; // the target BST object of this call to search()
	String ID; // parameter
	C t;
	C returnVal;

	void traverse() 
	{
		
		if (target != null && target.mark != GC.reachable)
			target.traverse();

		if (t != null && t.mark != GC.reachable)
			t.traverse();
		
		if (returnVal != null && returnVal.mark != GC.reachable)
			returnVal.traverse();
	}

	void search() 
	// Returns the C object in the target tree whose IDcode is equal to ID; returns null if no such object found.	
	// The type of this function is NonEmptyBST<C> x String--> C.
	{
		if (target.getClass() == NonEmptyBST.class) 
		{
			NonEmptyBST<C> t1 = (NonEmptyBST<C>) target;
			int i = ID.compareTo(t1.data.IDcode);
			if (i == 0) 
			{
				returnVal = t1.data; // return data
				//RuntimeStack.display();
			}
			else if (i < 0) 
			{
				ARsearch<C> newARsearch = new ARsearch<C>();
				newARsearch.target = t1.left;
				newARsearch.ID = ID; // pass parameter value
				RuntimeStack.push(newARsearch);
				newARsearch.search(); // call left.search(ID)
				t = newARsearch.returnVal;  // pass return value left.search(ID) to t
				RuntimeStack.pop();
				returnVal = t;  // store the value of  search(ID) = left.search(ID)
			}
			else // i > 0
			{ 
				ARsearch<C> newARsearch = new ARsearch<C>();
				newARsearch.target = t1.right;
				newARsearch.ID = ID; // pass parameter value
				RuntimeStack.push(newARsearch);
				newARsearch.search(); // call rigth.search(ID)
				t = newARsearch.returnVal;  // pass return value right.search(ID) to t
				RuntimeStack.pop();
				returnVal = t;  // store the value of  search(ID) = right.search(ID)
			}
		} 
		else // target.getClass() == EmptyBSt.class
		{
			System.out.println("Data object with the given IDcode " + ID + " does not exist in the tree.");
			returnVal = null;
		}
	}

}