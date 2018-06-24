abstract class Obj {
	static int newObjId = 0;
	int objId = newObjId++; // the unique object identifier
	// assign newObjId to objId, then increment newObjId
	boolean mark = GC.reachable; // used for mark-and-sweep GC emulation, replacing "visited" field used in
					// Project 2

	Obj() {
		DataStorage.addtoList(this);
	}

	public String toString() {
		return mark + ":" + objId + ":" + this.getClass().getName();
	}

	abstract void traverse(); // the function to perform depth-first traversal of the object graph starting
								// from this object
}