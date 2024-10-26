import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Experiments 
{

	public static void main(String[] args) 
	{
	    ProcessBuilder processBuilder = new ProcessBuilder();
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter number:");
	    int num = in.nextInt();
	    in.close();
	    
	    // Run a shell command
	    processBuilder.command("bash", "-c", "for i in {1.." + num + "}; do echo $i; done");
	    
	    try 
	    {

	        Process process = processBuilder.start();

	        StringBuilder output = new StringBuilder();

	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));

	        String line;
	        while ((line = reader.readLine()) != null) 
	        {
	            output.append(line + "\n");
	        }

	        int exitVal = process.waitFor();
	        if (exitVal == 0) 
	        {
	            System.out.println(output + "Success!");
	            System.exit(0);
	        } 
	        else 
	        {
	            //abnormal...
	        }

	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    } 
	    catch (InterruptedException e) 
	    {
	        e.printStackTrace();
	    }
	}

}
