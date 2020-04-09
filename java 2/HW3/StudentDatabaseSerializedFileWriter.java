import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
@author Thien Tommy Nguyen 
@version Version 1
**/

public class StudentDatabaseSerializedFileWriter{

    private static ObjectOutputStream output;
/**
@throws IOException try to output the file
 **/

    public static void openFile (String filename) {

        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));
			
        }   
        catch (IOException e) {
            System.err.println("io exception caught");
        }        
    }    
/**
@throws IOException try to write the student database
**/

    public static void writeData(StudentDatabase db)throws Exception {
      output.writeObject(db);
    }
/**
@throws IOException try to close the open file
**/

    public static void closeFile() throws Exception {
        if (output != null)
            output.close();
        output = null;
    }

}
