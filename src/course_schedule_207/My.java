package course_schedule_207;

import java.util.HashMap;

public class My {
    public boolean result(int numCourses, int[][] prerequisites){
        HashMap<Integer,Integer> prereq = new HashMap<>();
        boolean[] visited = new boolean[numCourses+1];
        visited[0] = true;

        for (int[] p : prerequisites)
            prereq.put(p[0],p[1]);

        return true;
    }
}

