package course_schedule_207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class My {
    public boolean result(int numCourses, int[][] prerequisites){
        HashMap<Integer, ArrayList<Integer>> prereq = new HashMap<>();

        for (int[] p : prerequisites){
            if (prereq.containsKey(p[0])){
                ArrayList<Integer> tmp = prereq.get(p[0]);
                tmp.add(p[1]);
            }else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(p[1]);
                prereq.put(p[0], tmp);
            }
        }

        for (int i = 0; i < numCourses; i++){
            boolean[] visited = new boolean[numCourses];
            boolean breaked = false;
            dfs(prereq, i, visited, numCourses);
            for (boolean b : visited){
                if (!b){
                    breaked = true;
                    break;
                }
            }
            if (!breaked)
                return true;
        }
        return false;
    }

    private void dfs(HashMap<Integer, ArrayList<Integer>> prereq, int start
            ,boolean[] visited, int numCourses) {
        if (prereq.containsKey(start)){
            for (int c : prereq.get(start)){
                if (!visited[c])
                    return;
            }
        }

        visited[start] = true;

        for (int i = 0; i < numCourses; i++){
            if (visited[i])
                continue;
            dfs(prereq, i, visited, numCourses);
        }
    }
}

