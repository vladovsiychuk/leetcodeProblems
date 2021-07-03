package minimum_height_trees_310;

import java.util.*;

public class My {
    public List<Integer> result(int n, int[][] edges){
        if (edges.length == 0)
            return new ArrayList<Integer>(Arrays.asList(0));
        else if (n == 2)
            return new ArrayList<Integer>(Arrays.asList(0,1));
        HashMap<Integer, List<Integer>> neighbords = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int[] count = new int[n];
        int[] depth = new int[n];
        boolean[] visited = new boolean[n];
        Integer flag = null;
        int max = 0;

        Arrays.fill(depth, 0);

        for (int[] e : edges){
            List<Integer> A = neighbords.getOrDefault(e[0], new ArrayList<>());
            A.add(e[1]);
            neighbords.put(e[0], A);
            List<Integer> B = neighbords.getOrDefault(e[1], new ArrayList<>());
            B.add(e[0]);
            neighbords.put(e[1], B);
            count[e[0]]++;
            count[e[1]]++;
        }

        for (int node = 0; node < n; node++){
            if (count[node] == 1)
                queue.add(node);
        }

        while (!queue.isEmpty() && queue.size() > 1){
            int node = queue.poll();
            visited[node] = true;
            for (int neighbord : neighbords.get(node)){
                if (visited[neighbord])
                    continue;

                count[neighbord]--;
                if (count[neighbord] == 1) {
                    depth[neighbord] = Math.max(depth[node]+1, depth[neighbord]);
                    max = Math.max(max, depth[neighbord]);
                    queue.add(neighbord);
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (max == depth[i])
                result.add(i);
        }

        return result;
    }
}

