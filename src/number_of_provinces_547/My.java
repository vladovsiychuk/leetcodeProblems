package number_of_provinces_547;

public class My {
    public int result(int[][] isConnected){
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++){
            if (!visited[i]){
                provinces++;
                dfs(isConnected, i, visited);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, int index, boolean[] visited) {
        visited[index] = true;

        for (int i : isConnected[index]) {
            if (!visited[i])
                dfs(isConnected,i,visited);
        }
    }
}

