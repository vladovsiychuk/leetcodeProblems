package number_of_connected_componenst_323;

public class My {
    public int result(int n, int[][] edges){
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++){
            if (visited[i])
                continue;
            count++;
            dfs(visited, i, edges);
        }
        return count;
    }

    private void dfs(boolean[] visited, int node, int[][] edges) {
        visited[node] = true;

        for (int[] edge : edges){
            if (edge[0] == node)
                dfs(visited, edge[1], edges);
            if (edge[1] == node)
                dfs(visited, edge[0], edges);
        }
    }
}

