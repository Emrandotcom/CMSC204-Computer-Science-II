
/**
 * @author Emran Abbamacha
 */

import java.io.*;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {

	public LinkedList<CourseDBElement>[] hashTable;

	/**
	 * Constructor that takes in an integer which represents the estimated size of
	 * the hash table.
	 * 
	 * @param cds: size of the hash table.
	 */
	public CourseDBStructure(int cds) {
		hashTable = new LinkedList[cds];
		for (int i = 0; i < cds; i++) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}

	/**
	 * Constructor that takes in a String and an integer
	 * 
	 * @param structure: used for testing
	 * @param cds:       size of the hash table
	 */
	public CourseDBStructure(String structure, int cds) {
		hashTable = new LinkedList[cds];
		for (int i = 0; i < cds; i++) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}

	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is in the
	 * hashtable.
	 * 
	 * If the CourseDatabaseElement does not exist in the hashtable, add it to the
	 * hashtable.
	 * 
	 * @param element the CDE to be added
	 */
	@Override
	public void add(CourseDBElement element) {
		element.hashcode = element.getCrn() % hashTable.length;
		int index = element.hashCode() % hashTable.length;
		hashTable[index].add(element);
	}

	/**
	 * 
	 * If the CourseDatabaseElement is in the hashtable, return it If not, throw an
	 * IOException
	 * 
	 * @param crn of the element (to be returned)
	 * @throws IOException
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		return hashTable[crn % hashTable.length].poll();
	}

	/**
	 * @return the size of the ConcordanceDataStructure (number of indexes in the
	 *         array)
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}

}
