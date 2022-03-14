package graphtheory;

public class DepthFirstSearch {
    public static void depthFirstSearch(int[][] graph, int current_vertex) {
        boolean[] visited = new boolean[graph.length];
        depthFirstSearch(graph, visited, current_vertex);
    }
    public static void depthFirstSearch(int[][] graph, boolean[] visited, int current_vertex) {
        System.out.println(current_vertex);
        visited[current_vertex] = true;
        for (int i = 0; i < graph[current_vertex].length; i++) {
            if (graph[current_vertex][i] > 0 && !visited[i]) {
                depthFirstSearch(graph, visited, i);
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
        depthFirstSearch(graph, 0);
    }
}
