
/**
 * @author Emran Abbamacha
 */

public class Road implements Comparable<Road> {

	protected Town source;
	protected Town destination;
	protected String name;
	protected int weight;

	/**
	 * Constructor
	 * 
	 * @param source      - One town on the road
	 * @param destination - Another town on the road
	 * @param degrees     - Weight of the edge, i.e., distance from one town to the
	 *                    other
	 * @param name        - Name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;
	}

	/**
	 * Constructor with weight preset at 1
	 * 
	 * @param source      - One town on the road
	 * @param destination - Another town on the road
	 * @param name        - Name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = 1;
		this.name = name;
	}

	/**
	 * Returns true only if the edge contains the given town
	 * 
	 * @param town - a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 * 
	 */
	public boolean contains(Town town) {
		if (source.equals(town) || destination.equals(town)) {
			return true;
		}
		return false;
	}

	/**
	 * To string method.
	 * 
	 */
	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * Returns the road name
	 * 
	 * @return The name of the road
	 * 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the second town on the road
	 * 
	 * @return A town on the road
	 * 
	 */
	public Town getDestination() {
		return this.destination;
	}

	/**
	 * Returns the first town on the road
	 * 
	 * @return A town on the road
	 * 
	 */
	public Town getSource() {
		return this.source;
	}

	/**
	 * Specified by: compareTo in interface Comparable<Road>
	 * 
	 * @return 0 if the road names are the same, a positive or negative number if
	 *         the road names are not the same
	 * 
	 */
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * Returns the distance of the road
	 * 
	 * @return the distance of the road
	 * 
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Returns true if each of the ends of the road r is the same as the ends of
	 * this road. Remember that a road that goes from point A to point B is the same
	 * as a road that goes from point B to point A.
	 * 
	 * @param r - road object to compare it to
	 */
	public boolean equals(Object r) {
		Road road = (Road) r;
		if (road.getSource().equals(new Town(source)) && road.getDestination().equals(new Town(destination))
				|| road.getSource().equals(new Town(destination)) && road.getDestination().equals(new Town(source))) {
			return true;
		}
		return false;
	}

}
