abstract class AR
{
	abstract void traverse();

	// This function will apply traverse() to every AR field whose type is a subclass of Obj, unless its value is null.
	// These fields are the root nodes from which depth-first traversal starts.
}