package merge_intervals_56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class My {
    public int[][] result(int[][] intervals) {
        List<Interval> intervalsList = new ArrayList<>();
        List<int[]> tmpIntervals = new ArrayList<>();

        for (int[] interval : intervals)
            intervalsList.add(new Interval(interval[0], interval[1]));

        Collections.sort(intervalsList);

        Interval current = intervalsList.get(0);

        for (int i = 0; i < intervalsList.size(); i++) {
            Interval selected = intervalsList.get(i);

            if (current.end < selected.start) {
                tmpIntervals.add(new int[]{current.start,current.end});
                current = selected;
            } else if (current.end < selected.end)
                current.end = selected.end;
        }

        tmpIntervals.add(new int[]{current.start,current.end});

        int[][] result = new int[tmpIntervals.size()][2];

        int i = 0;
        for (int[] interval : tmpIntervals)
            result[i++] = interval;

        return result;
    }

    private class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval other) {
            return this.start - other.start;
        }
    }
}
