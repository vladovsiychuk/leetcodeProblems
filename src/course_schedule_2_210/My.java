package course_schedule_2_210;

import java.util.*;

public class My {
    public int[] result(int numCourses, int[][] prerequisites) {
        HashMap<Integer, String> colors = new HashMap<>();
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        List<Integer> topological = new ArrayList<>();

        for (int[] p : prerequisites) {
            List<Integer> l = edges.getOrDefault(p[1], new ArrayList<>());
            l.add(p[0]);
            edges.put(p[1], l);
            colors.put(p[0], "WHITE");
            colors.put(p[1], "WHITE");
        }

        for (int course = 0; course < numCourses; course++){
            if (!colors.get(course).equals("WHITE"))
                continue;

            if(!dfs(course, colors, edges, topological))
                return new int[0];
        }
        int[] result = new int[topological.size()];
        for (int i = topological.size()-1, j = 0; i >= 0; i--,j++)
            result[j] = topological.get(i);
        return result;
    }

    private boolean dfs(int course, HashMap<Integer, String> colors, HashMap<Integer, List<Integer>> edges,
                     List<Integer> topological) {
        if (!edges.containsKey(course)){
            colors.put(course, "BLACK");
            topological.add(course);
            return true;
        }

        for (int edge : edges.get(course)){
            if (colors.get(edge).equals("GREY"))
                return false;
            else if (colors.get(edge).equals("BLACK"))
                continue;

            colors.put(edge, "GREY");
            if (!dfs(edge, colors, edges, topological))
                return false;
        }
        colors.put(course, "BLACK");
        topological.add(course);
        return true;
    }
}









