
/**
 * @author Emran Abbamacha
 */

public class Town implements Comparable<Town> {

	protected String name;

	/**
	 * Constructor. Requires town's name.
	 * 
	 * @param name
	 * 
	 */
	public Town(String name) {
		this.name = name;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param templateTown - an instance of Town
	 * 
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}

	/**
	 * Returns the town's name
	 * 
	 * @return town's name
	 * 
	 */
	public String getName() {
		return this.name;

	}

	/**
	 * Specified by: compareTo in interface Comparable<Road>
	 * 
	 * @return 0 if the road names are the same, a positive or negative number if
	 *         the road names are not the same
	 * 
	 */
	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * To string method
	 * 
	 * @return the town name
	 * 
	 */
	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * Hashcode for name of town
	 * 
	 * @return the hashcode for the name of the town
	 * 
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	/**
	 * Returns true if each of the ends of the road r is the same as the ends of
	 * this road. Remember that a road that goes from point A to point B is the same
	 * as a road that goes from point B to point A.
	 * 
	 * @param r - road object to compare it to
	 */
	public boolean equals(Object r) {
		return r == this || this.name.toLowerCase().equals(((Town) r).name.toLowerCase());

	}

}
