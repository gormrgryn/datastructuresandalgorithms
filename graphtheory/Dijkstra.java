package graphtheory;

import basicdatastructures.PriorityQueue;

public class Dijkstra {
    static class Vertex implements Comparable<Vertex> {
		int index;
		int minDistance;
		Vertex(int index, int minDistance) {
			this.index = index;
			this.minDistance = minDistance;
		}
		@Override
		public int compareTo(Dijkstra.Vertex o) {
			if (minDistance == o.minDistance) return 0;
			else if (minDistance > o.minDistance) return 1;
			else return -1;
		}
	}
    public static int[] dijkstra(int[][] graph, int start_vertex) {
		boolean[] visited = new boolean[graph.length];
		int[] distance = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			visited[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();

		distance[start_vertex] = 0;
		q.push(new Vertex(start_vertex, 0));

		while(!q.isEmpty()) {
			Vertex current_vertex = q.pop();
			visited[current_vertex.index] = true;

			for (int i = 0; i < graph[current_vertex.index].length; i++) {
				int adjacent_vertex_dist = graph[current_vertex.index][i];

				if (adjacent_vertex_dist >= 1 && !visited[i]) {
					int alt_dist = distance[current_vertex.index] + adjacent_vertex_dist;

					if (alt_dist < distance[i]) {
						distance[i] = alt_dist;
					}

					q.push(new Vertex(i, alt_dist));
				}
			}
		}
		return distance;
	}
}
