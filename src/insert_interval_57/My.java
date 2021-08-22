package insert_interval_57;

import educative.io.Interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class My {
    public int[][] result(int[][] intervals , int[] newInterval){
        List<Interval> input = new ArrayList<>();

        for (int[] i : intervals)
            input.add(new Interval(i[0],i[1]));

        List<Interval> result = new ArrayList<>();
        Iterator<Interval> iterator = input.iterator();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        boolean newProcessed = false;

        while(iterator.hasNext()){
            Interval current = iterator.next();
            if (newStart > current.end || newEnd < current.start){ //if not overlap
                if (!newProcessed && newEnd < current.start) {
                    result.add(new Interval(newStart, newEnd));
                    newProcessed = true;
                }
                result.add(current);
            }else{
                newStart = Math.min(newStart, current.start);
                newEnd = Math.max(newEnd, current.end);
            }
        }

        if (!newProcessed)
            result.add(new Interval(newStart, newEnd));

        int[][] resultArray = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i][0] = result.get(i).start;
            resultArray[i][1] = result.get(i).end;
        }


        return resultArray;
    }

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

