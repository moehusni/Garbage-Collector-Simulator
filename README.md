
PROJECT 4: Emulation of Mark-and-Sweep Garbage Collection Due: 05/20/18, Sunday, 11 PM
Late projects will not be accepted.
The purpose of this project is to acquire better understandings of mark-and-sweep garbage collection, as described in Course Notes #12, by emulating it inside source programs involving BSTs. In this project the root nodes of the object graph are the class-type fields of the AR objects contained in the runtime stack. Use depth-first traversal of the object graph in the mark phase.
This project must be implemented by expanding these class templates. The required functionalities are described in comments. You will need to add classes implementing your runtime stack (used in Project 3) and data structure maintaining constructed Obj objects (used in Project 1 & 2).
Each call to GC.gc( ) is to perform GC emulation and display the following in an output file:
A list of the Obj objects traversed in the mark phase. Display each object in the format: mark:objId:className:(optional info).
A list of the Obj objects swept in the sweep phase. Display each object in the format: sign:mark:objId:className:(optional info) where sign is "+" or "−" according as the object is reachable or unreachable.
The total # of reachable objects. The total # of unreachable objects.
Here's an example of expected output from running MainGCtest.main.
You might want to invoke GC emulation at different times for testing/experimentation, but the submitted program must invoke it at the exact times specified in the class templates. For example, here's an expected output from modified MainGCtest.main and AR_BST_test.BST_test where GC.gc( ) is invoked when every call to delete( ) is about to return but at no other times. Notice carefully that whenever the PC object to be deleted is found in a node whose left or right subtree is empty, their garbage collection is delayed to the next invocation of GC.gc( ) because they are still reachable from the target field until the AR object is popped.
(Note: In reality, the ObjId values of the garbage-collected objects should be recycled and reused, but this is omitted in this project.)
Submission
Email the following materials to keitaro.yukawa@gmail.com with the subject header: CS 316, Project 4, your full name
All the classes comprising your source code – make sure to double check no classes are missing.
              http://picasso.cs.qc.cuny.edu/cs316/316proj4.html Page 1 of 2
CS 316 Project 4 6/20/18, 2)18 PM
A concise description of the implementations of the runtime stack and the data structure maintaining constructed Obj objects.
You may email the entire materials in a .zip or .rar compressed file.
The due date is 05/20/18, Sunday, 11 PM. No late projects will be accepted. If you haven't been able to complete the project, you may send an incomplete program for partial credit. In this case, include a description of what is and is not working in your program along with what you believe to be the sources of the problems.
