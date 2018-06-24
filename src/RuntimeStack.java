abstract class RuntimeStack 
{
	 
    static int topOfStack = -1;
    static final AR runtimeStack[] = new AR[10000];
    static int maxCall = 0;
     static int maxSoFar = 0;

    public static boolean isEmpty( )
    {
        return topOfStack == -1;
    }
   
    public static void pop( ) 
    {
       topOfStack--;
    }
 
    public static void push( AR x )
    {
       
    	 runtimeStack[ ++topOfStack ] = x;
        if(maxSoFar < topOfStack+1){
        	maxSoFar = topOfStack+1;
        }
        ++maxCall;
    }
    
    public static void display() 
    {
    	Output.displayln("-----------------------------------------------------------");
    	Output.displayln("The total number of function calls so far = " + maxCall);
    	Output.displayln("The maximum stack size so far = " + maxSoFar+ "\n");
    	Output.displayln("The contents of the runtime stack will be displayed from top to bottom: \n");
    	for (int i = topOfStack; i>=0; i--){
    		Output.displayln(runtimeStack[i].toString());
    	}
    }
}