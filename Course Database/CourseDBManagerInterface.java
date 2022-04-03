
import java.io.*;
import java.util.*;

public interface CourseDBManagerInterface {

	/**
	 * Create and add an entry using CourseDBStructure's add method.
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor);

	/**
	 * Get an entry using CourseDBStructure's get method.
	 */
	public CourseDBElement get(int crn);

	/**
	 * Read a given file of courses and add them to the DB.
	 * 
	 * @param input file to be read
	 */
	public void readFile(File input) throws FileNotFoundException;

	/**
	 * Return an ArrayList of the courses in the order of CRN.
	 */
	public ArrayList<String> showAll();

}
