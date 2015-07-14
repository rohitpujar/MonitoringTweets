import java.io.FileWriter;
import java.io.IOException;


public class Util {

	public static void writeStringToFile(String stringToBeWritten) throws IOException{    
        try
        {
            String filename= ("/home/sachin/workspace/bigdata/TweetStream/tweets.txt");
            boolean append = true;
            FileWriter fw = new FileWriter(filename,append);

            fw.write(stringToBeWritten);//appends the string to the file
            fw.write("\n");
            fw.close();
        }

        catch(IOException ioe)
        {
            System.err.println("IOException while writing tweet to file: " + ioe.getMessage());
        }

    }

	public static void writeOnlyTweetToFile(String stringToBeWritten) throws IOException{    
        try
        {
            String filename= ("/home/sachin/workspace/bigdata/TweetStream/tweetsonly.txt");
            boolean append = true;
            FileWriter fw = new FileWriter(filename,append);

            fw.write(stringToBeWritten);//appends the string to the file
            fw.write("\n");
            fw.close();
        }

        catch(IOException ioe)
        {
            System.err.println("IOException while writing tweet to file: " + ioe.getMessage());
        }

    }
}
