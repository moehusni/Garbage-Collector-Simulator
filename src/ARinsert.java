class ARinsert<C extends Data> extends AR {
	BST<C> target; // the target BST object of this call to insert()
	C c; // parameter
	NonEmptyBST<C> returnVal;

	void traverse() 
	{

		if (target != null && target.mark != GC.reachable)
			target.traverse();

		if (c != null && c.mark != GC.reachable)
			c.traverse();

		if (returnVal != null && returnVal.mark != GC.reachable)
			returnVal.traverse();
	}

	void insert() {

		if (target.getClass() == NonEmptyBST.class) {
			// Returns the nonempty tree obtained by inserting parameter C object into the
			// target tree.
			NonEmptyBST<C> t1 = (NonEmptyBST<C>) target;
			int i = c.IDcode.compareTo(t1.data.IDcode);
			if (i < 0) {
				ARinsert<C> newARinsert = new ARinsert<C>();
				newARinsert.target = t1.left;
				newARinsert.c = c; // pass parameter value
				RuntimeStack.push(newARinsert);
				newARinsert.insert(); // call left.insert(c)
				t1.left = newARinsert.returnVal; // Store the return value left = left.insert(c)
				RuntimeStack.pop();
			} else if (i > 0) {
				ARinsert<C> newARinsert = new ARinsert<C>();
				newARinsert.target = t1.right;
				newARinsert.c = c; // pass parameter value
				RuntimeStack.push(newARinsert);
				newARinsert.insert(); // call right.insert(c);
				t1.right = newARinsert.returnVal; // Store the return value of right = right.insert(c)
				RuntimeStack.pop();
			} else // i == 0, c.IDcode == data.IDcode
			{
				System.out
						.println("Data object with the same IDcode " + t1.data.IDcode + " already exists in the tree.");
			}
			returnVal = t1;

		} else // target.getClass() == EmptyBST.class
				// Inserts parameter C object into the empty tree, and returns the resulting
				// non-empty tree.
		{
			returnVal = new NonEmptyBST<C>(c, target, target);
			// RuntimeStack.display();
		}
		
	}
	
	// as implemented in Project 3
}