class AR_BST_test extends AR {
	BST<PC> pcBST;

	void traverse()
	{
		
		if(pcBST !=null && pcBST.mark != GC.reachable )
			pcBST.traverse();
	}

	void BST_test() {
		pcBST = new EmptyBST<PC>();

		/*
		 * Construct pcBST of the following PC objects as per previous projects:
		 * 
		 * Smartphone IDcode = "s001" Laptop IDcode = "l001" Desktop IDcode = "d001"
		 * Smartphone IDcode = "s002" Laptop IDcode = "l002" Desktop IDcode = "d002"
		 * Smartphone IDcode = "s003" Laptop IDcode = "l003" Desktop IDcode = "d003"
		 * Smartphone IDcode = "s004" Laptop IDcode = "l004" Desktop IDcode = "d004"
		 */

		Smartphone smartPhone1 = new Smartphone("s001");
		pcBST = insert(smartPhone1, pcBST);
		
		Laptop laptop1 = new Laptop("l001");
		pcBST = insert(laptop1, pcBST);
		
		Desktop desktop1 = new Desktop("d001");
		pcBST = insert(desktop1, pcBST);
		
		Smartphone smartPhone2 = new Smartphone("s002");
		pcBST = insert(smartPhone2, pcBST);
		
		Laptop laptop2 = new Laptop("l002");
		pcBST = insert(laptop2, pcBST);
		
		Desktop desktop2 = new Desktop("d002");
		pcBST = insert(desktop2, pcBST);
		
		Smartphone smartPhone3 = new Smartphone("s003");
		pcBST = insert(smartPhone3, pcBST);
		
		Laptop laptop3 = new Laptop("l003");
		pcBST = insert(laptop3, pcBST);
		
		Desktop desktop3 = new Desktop("d003");
		pcBST = insert(desktop3, pcBST);
		
		Smartphone smartPhone4 = new Smartphone("s004");
		pcBST = insert(smartPhone4, pcBST);
		
		Laptop laptop4 = new Laptop("l004");
		pcBST = insert(laptop4, pcBST);
		
		Desktop desktop4 = new Desktop("d004");
		pcBST = insert(desktop4, pcBST);
		GC.gc(); // invoke GC emulation

		/*
		 * Delete the following PC objects from pcBST:
		 * 
		 * Smartphone IDcode = "s001" Laptop IDcode = "l001" Desktop IDcode = "d001"
		 */
		pcBST = delete("s001", pcBST);
		pcBST = delete("l001", pcBST);
		pcBST = delete("d001", pcBST);
		GC.gc(); // invoke GC emulation

		/*
		 * Delete the following PC objects from pcBST:
		 * 
		 * Smartphone IDcode = "s002" Laptop IDcode = "l002" Desktop IDcode = "d002"
		 */
		pcBST = delete("s002", pcBST);
		pcBST = delete("l002", pcBST);
		pcBST = delete("d002", pcBST);
		GC.gc(); // invoke GC emulation
		search("d001", pcBST);
		search("d002", pcBST);
		search("d003", pcBST);
		search("d004", pcBST);
		
	}

	private static BST<PC> delete(String ID, BST<PC> pcBST)

	// helping function Not a part of Runtime Stack.

	{

		ARdelete<PC> newARdelete = new ARdelete<PC>();
		newARdelete.target = pcBST;
		newARdelete.ID = ID;
		RuntimeStack.push(newARdelete);
		newARdelete.delete();
		RuntimeStack.pop();
		return newARdelete.returnVal;
	}

	private static BST<PC> insert(PC pc, BST<PC> pcBST)

	// helpping function Not a part of Runtime Stack.

	{
		ARinsert<PC> newARinsert = new ARinsert<PC>();
		newARinsert.target = pcBST;
		newARinsert.c = pc;
		RuntimeStack.push(newARinsert);
		newARinsert.insert();
		RuntimeStack.pop();

		return newARinsert.returnVal;
	}
	
	
	private static void search(String string, BST<PC> pcs) 
	
	// helping function Not a part of Runtime Stack.
	
	{
		ARsearch<PC> newARsearch = new ARsearch<PC>();
		newARsearch.target = pcs;
		newARsearch.ID = string;
		RuntimeStack.push(newARsearch);
		newARsearch.search();
		RuntimeStack.pop();
	}


}
