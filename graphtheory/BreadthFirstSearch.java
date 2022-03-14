package graphtheory;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	public static void breadthFirstSearch(int[][] graph) {
		breadthFirstSearch(graph, 0);
	}
    public static void breadthFirstSearch(int[][] graph, int start_vertex) {
    	boolean[] visited = new boolean[graph.length];
    	Queue<Integer> q = new LinkedList<Integer>();

    	visited[start_vertex] = true;
    	q.add(start_vertex);

    	while (!q.isEmpty()) {
    		int current_vertex = q.poll();
    		System.out.println(current_vertex);

    		for (int i = 0; i < graph[current_vertex].length; i++) {
    			if (graph[current_vertex][i] > 0) {
    				if (!visited[i]) {
    					q.add(i);
    					visited[i] = true;
    				}
    			}
    		}
    	}
    }
    public static void main(String[] args) {
    	int[][] graph = {
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        breadthFirstSearch(graph);
    }
}
