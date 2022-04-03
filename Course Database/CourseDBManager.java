
/**
 * @author Emran Abbamacha
 */

import java.io.*;
import java.util.*;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure cds;

	public CourseDBManager() {
		cds = new CourseDBStructure(100);
	}

	/**
	 * The add method uses the CDS add method to create a CDE element and add it to
	 * the data structure
	 * 
	 * @param id:         course id
	 * @param crn:        course crn
	 * @param credits:    number of credits for course
	 * @param roomNum:    number of room
	 * @param instructor: course instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		cds.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	/**
	 * The get method uses the CDS get method to retrieve a CDE element from the
	 * data structure and handle the exception if not found.
	 * 
	 * @param crn: course crn that CDE retrieves
	 * @return the CDE element, if found otherwise null
	 * @throws IOException when user selects an input file cannot be read, or
	 *                     attempting to retrieve a CDE that does not exist in the
	 *                     DB
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		} catch (IOException e) {
			System.out.println(
					"Input file cannot be read, or attempting to retrieve a CDE that does not exist in the DB");
			e.getMessage();
		}
		return null;
	}

	/**
	 * Read a given file of courses and add them to the DB.
	 * 
	 * @param input file to be read
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner keyboard = new Scanner(input);
		while (keyboard.hasNextLine()) {
			String data = keyboard.nextLine();
			System.out.println(data);
		}
		keyboard.close();
	}

	/**
	 * @return an ArrayList of the courses in the order of CRN.
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arrList = new ArrayList<String>();
		for (LinkedList<CourseDBElement> i : cds.hashTable) {
			for (Object o : i.toArray()) {
				arrList.add(((CourseDBElement) o).toString());
			}
		}
		return arrList;
	}

}
