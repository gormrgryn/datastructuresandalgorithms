package graphtheory;

public class FloydWarshall {
    public static int[][] floydWarshall(int[][] graph) {
		int n = graph.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && graph[i][j] == 0) graph[i][j] = 100000;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		return graph;
	}
}
