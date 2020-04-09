import java.io.*;
public class Tester{
	public static StudentDatabaseIO data = new StudentDatabaseIO();

	public static void main(String[]args)throws Exception{
	try{
		data.formatedToSeralized("sortedStudents.csv","formatedToSeralized.ser");
		data.seralizedToFormatted("formatedToSeralized.ser","seralizedAndFormatedSudents.csv");
	}
	catch(IOException ex){
		System.out.println("IO Exception was caught");
	}
}
}