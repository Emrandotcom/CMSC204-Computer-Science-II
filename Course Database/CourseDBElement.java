
/**
 * @author Emran Abbamacha
 */

public class CourseDBElement implements Comparable {

	public String id;
	public int crn;
	public int credits;
	public String roomNum;
	public String instructor;
	public int hashcode;

	/**
	 * CourseDBElement constructor
	 * 
	 * @param id:         course id
	 * @param crn:        course crn
	 * @param credits:    number of credits for course
	 * @param roomNum:    number of room
	 * @param instructor: course instructor
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	/**
	 * CourseDBElement empty constructor
	 */
	public CourseDBElement() {
		this.id = "";
		this.crn = 0;
		this.credits = 0;
		this.roomNum = "";
		this.instructor = "";
	}

	/**
	 * Get the course id
	 * 
	 * @return course id number
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the course id
	 * 
	 * @param course id number
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the course crn
	 * 
	 * @return course crn
	 */
	public int getCrn() {
		return crn;
	}

	/**
	 * Set the course crn
	 * 
	 * @param course crn
	 */
	public void setCrn(int crn) {
		this.crn = crn;
	}

	/**
	 * Get the course credits
	 * 
	 * @return number of credits of course
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Set the course credits
	 * 
	 * @param number of credits of course
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Get the course room number
	 * 
	 * @return number of room as String
	 */
	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * Set the course room number
	 * 
	 * @param number of room as String
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	/**
	 * Get the course instructor
	 * 
	 * @return instructor's name
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * Set the course instructor
	 * 
	 * @param instructor's name
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * @return the hashcode computation of the CDE based on the string value of the
	 *         CRN
	 */
	public int hashCode() {
		return String.valueOf(crn).hashCode();
	}

	/**
	 * Compares the crn of the course
	 * 
	 * @param element to be compared to
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return Integer.compare(this.getCrn(), element.getCrn());
	}

	/**
	 * @return course information in String
	 */
	@Override
	public String toString() {
		return "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:"
				+ roomNum;
	}

}
