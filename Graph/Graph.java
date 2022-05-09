
/**
 * @author Emran Abbamacha
 */

import java.util.*;

public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> towns = new HashSet<Town>();
	private Set<Road> roads = new HashSet<Road>();

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road result = null;

		for (Road road : roads) {
			if (road.contains(sourceVertex) == false || road.contains(destinationVertex) == false) {
				continue;
			}
			result = road;
			break;
		}

		return result;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(newRoad);
		return newRoad;
	}

	@Override
	public boolean addVertex(Town v) {
		if (towns.contains(v)) {
			return false;
		}

		towns.add(v);

		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for (Town town : towns)
			if (town.equals(v))
				return true;
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> result = new HashSet<>();

		for (Road road : roads) {
			if (!road.contains(vertex)) {
				continue;
			}

			result.add(road);
		}

		return result;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road result = null;

		for (Road road : roads) {
			if (road.contains(destinationVertex) && road.contains(sourceVertex) && (weight > -1)
					&& description != null) {
				result = road;
			}
		}
		if (roads.remove(result)) {
			return result;
		}
		return result;

	}

	@Override
	public boolean removeVertex(Town v) {

		if (v == null || towns.contains(v) == false) {
			return false;
		}

		towns.remove(v);
		return true;
	}

	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		Set<Town> checked;
		Set<Town> unchecked;
		ArrayList<String> path = new ArrayList<String>();

		dijkstraShortestPath(sourceVertex);

		checked = new HashSet<Town>();
		unchecked = new HashSet<Town>(towns);
		checked.add(sourceVertex);
		unchecked.remove(sourceVertex);

		Collections.reverse(path);
		return path;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		int[] distance;
		String[] prev;
		ArrayList<String> towns;
		HashMap<String, HashMap<String, Road>> adjacencyMatrix = new HashMap<String, HashMap<String, Road>>();

		String source = ((Town) sourceVertex).getName();

		List<Town> vertices = new ArrayList<Town>(vertexSet());
		towns = new ArrayList<String>();
		ArrayList<String> unvisited = new ArrayList<String>();

		for (Town vertex : vertices) {
			towns.add(vertex.getName());
			unvisited.add(vertex.getName());
		}

		distance = new int[towns.size()];
		prev = new String[towns.size()];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[towns.indexOf(source)] = 0;

		while (!unvisited.isEmpty()) {
			HashMap<String, Road> connected_nodes = adjacencyMatrix.get(source);
			for (String t : connected_nodes.keySet()) {
				if (unvisited.indexOf(t) != -1 && connected_nodes.get(t) != null) {
					int ind = towns.indexOf(t);
					int curr_ind = towns.indexOf(source);
					int weight = connected_nodes.get(t).getWeight();
					if (distance[curr_ind] + weight < distance[ind]) {

						distance[ind] = weight + distance[curr_ind];
						prev[ind] = source;
					}

				}

			}
			unvisited.remove(unvisited.indexOf(source));
			if (unvisited.isEmpty()) {
				break;
			}

			int shortest = Integer.MAX_VALUE;
			int shortest_ind = -1;
			for (String t : unvisited) {
				int ind = towns.indexOf(t);
				if (distance[ind] < shortest) {
					shortest = distance[ind];
					shortest_ind = ind;
				}
			}

			if (shortest_ind == -1) {

				break;
			}
			source = towns.get(shortest_ind);

		}
	}

}
