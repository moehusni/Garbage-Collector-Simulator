class ARdelete<C extends Data> extends AR {
	BST<C> target; // the target BST object of this call to delete()
	String ID; // parameter
	BST<C> returnVal;

	void traverse()
	{

		if (target != null && target.mark != GC.reachable)
			target.traverse();

		if (returnVal != null && returnVal.mark != GC.reachable)
			returnVal.traverse();

	}

	void delete() {
		if (target.getClass() == NonEmptyBST.class)
		// Returns the tree obtained by deleting from the target tree the C object whose
		// IDcode is equal to ID.
		{
			NonEmptyBST<C> t1 = (NonEmptyBST<C>) target;
			int i = ID.compareTo(t1.data.IDcode);
			if (i < 0) {
				ARdelete<C> newARdelete = new ARdelete<C>();
				newARdelete.target = t1.left;
				newARdelete.ID = ID; // pass parameter value
				RuntimeStack.push(newARdelete);
				newARdelete.delete(); // call left.delete(ID)
				t1.left = newARdelete.returnVal; // this.left <-- left.delete(ID);
				RuntimeStack.pop();
				returnVal = t1;
			} else if (i > 0) {
				ARdelete<C> newARdelete = new ARdelete<C>();
				newARdelete.target = t1.right;
				newARdelete.ID = ID; // pass parameter value
				RuntimeStack.push(newARdelete);
				newARdelete.delete(); // call right.delete(ID)
				t1.right = newARdelete.returnVal; // this.right <-- right.delete(ID)
				RuntimeStack.pop();
				returnVal = t1;
			} else // i == 0, ID == data.IDcode, the object with ID found at the root
			{
				if (t1.left instanceof EmptyBST) {
					returnVal = t1.right; // return right
					// RuntimeStack.display();
				} else if (t1.right instanceof EmptyBST) {
					returnVal = t1.left; // return left
					// RuntimeStack.display();
				} else // left is nonempty & right is nonempty
				{
					// search for the object whose IDcode is the predecessor of ID, which is the
					// maximum (rightmost) key in the left subtree;
					// replace data by that object;
					// delete the node containing that object;

					NonEmptyBST<C> t = (NonEmptyBST<C>) t1.left;
					if (t.right instanceof EmptyBST) {
						t1.data = t.data;
						t1.left = t.left;
						returnVal = t1;
						// RuntimeStack.display();
					} else // t.right is nonempty
					{

						while (!(((NonEmptyBST<C>) t.right).right instanceof EmptyBST))
							t = (NonEmptyBST<C>) t.right;
						t1.data = ((NonEmptyBST<C>) t.right).data;
						t.right = ((NonEmptyBST<C>) t.right).left;
						returnVal = t1;
						// RuntimeStack.display();
					}
				}
			}
		} else // target.getClass() == EmptyBST.class
				// If the tree has no such object, issues a message and returns the target tree
				// unchanged.

		{
			System.out.println("Data object with the given IDcode " + ID + " does not exist in the tree.");
			returnVal = target;
		}
	}

}