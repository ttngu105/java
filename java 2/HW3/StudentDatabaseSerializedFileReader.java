import java.io.*;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
@author Thien Tommy Nguyen 
@version Version 1
**/

public class StudentDatabaseSerializedFileReader {

    private static ObjectInputStream input;
/**
@throws IOException try to open file
**/

    public static void openFile (String filename) {

        try {
            input = new ObjectInputStream(new FileInputStream(filename));
        }   
        catch (IOException e) {
            System.err.println("Error opening file.  Terminating");
        }        
    }    
/**

@throws IOException try to read data from the file that was opened
**/

    public static StudentDatabase readData()throws Exception  {
                   
        return (StudentDatabase)input.readObject();
    }

    public static void closeFile() throws Exception{
        if (input != null)
            input.close();
        input = null;
    }

}
