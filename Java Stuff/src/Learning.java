import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Learning {
	public static void main(String[] args) throws IOException
	{
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		
		File file = new File("test.sh");
		if(!file.exists()) file.createNewFile();
		FileWriter writer = new FileWriter(file);
		writer.write("cd ~/Documents/Runnable\\ .jar/\ntouch /Users/Ali/text.sh\ncd ~\nchmod u+x text.sh\n");
		File file1 = new File("/Users/Ali/text.sh");
		if(!file1.exists()) file.createNewFile();
		FileWriter write = new FileWriter(file1);
		write.write("for i in {1..10}\ndo\necho $i\ndone");
		writer.write("./text.sh\ncd ~/eclipse-workspace/Java\\ Stuff/");
		write.close();
		writer.close();
		Scanner in = new Scanner(file);
		while(in.hasNext()) System.out.println(in.nextLine());	
		in.close();
		
		
		processBuilder.command("bash", "-l", "./test.sh");
		
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
