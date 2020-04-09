import java.io.*;

/**
@author Thien Tommy Nguyen 
@version Version 1
**/

public class StudentDatabaseIO{
	
	StudentDatabaseSerializedFileWriter dataOut;
	StudentDatabaseSerializedFileReader dataIn;
/**
@throws IOException if an output or input is void
**/

		public void formatedToSeralized(String inputFilename ,String outputFilename )throws Exception{
			StudentDatabaseCSVFileReader.openFile(inputFilename);
			StudentDatabase db = StudentDatabaseCSVFileReader.readData();
			StudentDatabaseCSVFileReader.closeFile();
			
			db.sortByGPA();
			
			dataOut.openFile(outputFilename);
			dataOut.writeData(db);
			dataOut.closeFile();
		}
/**
@throws IOException if an output or input is void
**/
		public void seralizedToFormatted(String inputFilename ,String outputFilename)throws Exception{
			try{
			dataIn.openFile(inputFilename);
			StudentDatabase db = dataIn.readData();
			dataOut.openFile(outputFilename);
			dataOut.writeData(db);
			dataOut.closeFile();
			}
			catch(IOException e)
			{
				System.out.println("caught IO exception");
			}
		}
}
