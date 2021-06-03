package keys_and_rooms_841;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class My {
    public boolean result(List<List<Integer>> rooms){
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        for (int key : rooms.get(0))
            if(!visited[key]) {
                dfs(rooms, key, visited);
            }

        for (boolean b : visited)
            if(b == false) {
                return false;
            }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {
        visited[index] = true;

        for(int key: rooms.get(index)){
            if(!visited[key])
                dfs(rooms, key, visited);
        }
    }
}

