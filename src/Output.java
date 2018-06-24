import java.io.*;

public abstract class Output
{
	public static PrintWriter outStream;

	public static void display(String s)
	{
		outStream.print(s);
	}

	public static void displayln(String s)
	{
		outStream.println(s);
	}

	public static void setOutput(String outFile)

	// Sets the output stream to "outFile".

	{
		try
		{
			outStream = new PrintWriter( new FileOutputStream(outFile) );
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeOutput()
	{
		outStream.close();
	}
} 
