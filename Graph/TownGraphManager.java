
/**
 * @author Emran Abbamacha
 */

import java.io.*;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph townGraph = new Graph();

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		if (townGraph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null) {
			return true;
		}
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		return ((Road) townGraph.getEdge(new Town(town1), new Town(town2))).getName();
	}

	@Override
	public boolean addTown(String v) {
		return townGraph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		return new Town(name);
	}

	@Override
	public boolean containsTown(String v) {
		return townGraph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return townGraph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> result = new ArrayList<>();
		for (Road road : townGraph.edgeSet())
			result.add(road.getName());

		result.sort(String.CASE_INSENSITIVE_ORDER);
		return result;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		if (townGraph.removeEdge(new Town(town1), new Town(town2), 0, road) != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		return townGraph.removeVertex(getTown(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<Town> towns = new ArrayList<Town>(townGraph.vertexSet());
		ArrayList<String> arrayList = new ArrayList<String>();
		for (Town t : towns) {
			arrayList.add(t.getName());
		}
		Collections.sort(arrayList);
		return arrayList;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return townGraph.shortestPath(this.getTown(town1), this.getTown(town2));
	}

	@Override
	public void populateTownGraph(File file) throws FileNotFoundException, IOException {
		ArrayList<String> result = new ArrayList<String>();
		Scanner keyboard = new Scanner(file);

		while (keyboard.hasNextLine()) {
			result.add(keyboard.nextLine());
		}

		keyboard.close();

		for (String line : result) {
			String[] r = line.split(";");
			String roadName = r[0].split(",")[0];
			int weight = Integer.parseInt(r[0].split(",")[1]);
			String source = r[1].trim();
			String destination = r[2].trim();

			addTown(source);
			addTown(destination);
			addRoad(source, destination, weight, roadName);
		}
	}

}
