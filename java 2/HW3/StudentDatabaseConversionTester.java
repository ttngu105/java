import static org.junit.Assert.*;
import org.junit.*;
import java.io.File;
import java.io.IOException;

public class StudentDatabaseConversionTester{


    @BeforeClass
    public static void buildARandomDatabase() {
    
        ProcessBuilder pb = new ProcessBuilder("java", "MakeRandomStudents", "19");
        File log = new File("studentJUnitTestData.csv");
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        try {
            Process p = pb.start();
        }
        catch (IOException e) {
            System.err.println("error starting external process");
        }
    }

    @Test
    public void testReadFromCSVThenWriteToCSV() {
         StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
         StudentDatabase db = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();
 
         StudentDatabaseCSVFileWriter.openFile("studentJUnitTestData_out1.csv");
         StudentDatabaseCSVFileWriter.writeData(db);
         StudentDatabaseCSVFileWriter.closeFile();

         StudentDatabaseCSVFileReader.openFile("studentJUnitTestData_out1.csv");
         StudentDatabase db2 = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();
        
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
    }

    @Test
    public void testReadFromCSVThenWriteToSerialized()throws Exception {
         StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
         StudentDatabase db = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();
 
         StudentDatabaseSerializedFileWriter.openFile("studentJUnitTestData_out2.ser");
         StudentDatabaseSerializedFileWriter.writeData(db);
         StudentDatabaseSerializedFileWriter.closeFile();

         StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out2.ser");
         StudentDatabase db2 = StudentDatabaseSerializedFileReader.readData();
         StudentDatabaseSerializedFileReader.closeFile();
        
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
    
    }

    @Test
    public void testReadFromSerializedThenWriteToCSV() throws Exception{
         StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
         StudentDatabase db = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();
 
         StudentDatabaseSerializedFileWriter.openFile("studentJUnitTestData_out2.ser");
         StudentDatabaseSerializedFileWriter.writeData(db);
         StudentDatabaseSerializedFileWriter.closeFile();

         StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out2.ser");
         StudentDatabase db2  = StudentDatabaseSerializedFileReader.readData();
         StudentDatabaseSerializedFileReader.closeFile();

         StudentDatabaseCSVFileWriter.openFile("studentJUnitTestData_out3.csv");
         StudentDatabaseCSVFileWriter.writeData(db2);
         StudentDatabaseCSVFileWriter.closeFile();

         StudentDatabaseCSVFileReader.openFile("studentJUnitTestData_out3.csv");
         StudentDatabase db3 = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();

         // now compare the two databases
         assertEquals(db.getNumStudents(), db3.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db3.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
    
    }

    @Test
    public void testReadFromSerializedThenWriteToSerialized() throws Exception{
         StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out2.ser");
         StudentDatabase db  = StudentDatabaseSerializedFileReader.readData();
         StudentDatabaseSerializedFileReader.closeFile();


         StudentDatabaseSerializedFileWriter.openFile("studentJUnitTestData_out4.ser");

         StudentDatabaseSerializedFileWriter.writeData(db);
         StudentDatabaseSerializedFileWriter.closeFile();


         StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out4.ser");
         StudentDatabase db2 = StudentDatabaseSerializedFileReader.readData();
         StudentDatabaseSerializedFileReader.closeFile();
         // now compare the two databases
         assertEquals(db.getNumStudents(), db2.getNumStudents());
         for (int i=0; i<db.getNumStudents(); i++) {
            Student s1 = db.getStudent(i);
            Student s2 = db2.getStudent(i);
            assertEquals(s1.getStudentID(),s2.getStudentID());
            assertEquals(s1.getSex(),s2.getSex());
            assertEquals(s1.getEthnicGroup(),s2.getEthnicGroup());
            assertEquals(s1.getFirstName(),s2.getFirstName());
            assertEquals(s1.getLastName(),s2.getLastName());
            assertEquals(s1.getMiddleInitial(),s2.getMiddleInitial());
            assertEquals(s1.getProgram(),s2.getProgram());
            assertEquals(s1.getAcademicPlan(),s2.getAcademicPlan());
            assertEquals(s1.getSubPlan(),s2.getSubPlan());
            assertEquals(s1.getStrtLevel(),s2.getStrtLevel());
            assertEquals(s1.getTotal(),s2.getTotal(),0.01);
            assertEquals(s1.getGPA(),s2.getGPA(),0.01);
            assertEquals(s1.getFAFSA(),s2.getFAFSA());
            assertEquals(s1.getTakePrgrs(),s2.getTakePrgrs(),0.01);
            assertEquals(s1.getFinancialNeed(),s2.getFinancialNeed(),0.01);
         }
    
    }



}