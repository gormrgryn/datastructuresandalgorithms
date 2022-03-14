package graphtheory;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCycle {
    public static int[][] graph;
	public static int[][] edgelist;
    
    public static boolean bfs(int start_vertex) {
        int[] visited = new int[graph.length];
        for(int j = 0; j < visited.length; j++) visited[j] = -1;
        Queue<Integer> q = new LinkedList<Integer>();

        visited[start_vertex] = 0;
        q.add(start_vertex);
        
        boolean b = false;
        while(!q.isEmpty()) {
            int current_vertex = q.poll();
            visited[current_vertex] = 1;
            for(int i = 0; i < graph[current_vertex].length; i++) {
                if (graph[current_vertex][i] == 1) {
                    if (visited[i] == -1) {
                        q.add(i);
                        visited[i] = 0;
                    }
                    else if (visited[i] == 0) {
                        b = true;
                        break;
                    }
                }
            }
        }
        return b;
    }
	public static boolean checkCycle() {
		graph = new int[10][10];
        
        for(int j = 0; j < graph.length; j++) {
            for(int k = 0; k < graph.length; k++) {
                graph[j][k] = 0;
            }
        }
        for(int i = 0; i < edgelist.length; i++) {
            graph[edgelist[i][0]][edgelist[i][1]] = 1;
        }
        
        return bfs(0);
	}
	public static void main(String[] args) {
		edgelist = new int[][] {
			{0, 1},
			{1, 2},
			{2, 3},
			{2, 4},
			{3, 4}
		};
		System.out.println(checkCycle());
	}
}
