package reorder_data_in_logs_file_937;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class My {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long M = 1000000007;
        List<Integer> horCuts = new ArrayList<>();
        List<Integer> verCuts = new ArrayList<>();
        int maxVerDiff = 1;
        int maxHorDiff = 1;

        for (int cut : horizontalCuts)
            horCuts.add(cut);
        for (int cut : verticalCuts)
            verCuts.add(cut);

        horCuts.add(h);
        verCuts.add(w);
        horCuts.add(0);
        verCuts.add(0);

        Collections.sort(horCuts);
        Collections.sort(verCuts);

        for (int i = 1; i < verCuts.size(); i++) {
            int horDirr = horCuts.get(i)-horCuts.get(i-1);
            if (horDirr > maxHorDiff)
                maxHorDiff = horDirr;
        }

        for (int i = 1; i < verCuts.size(); i++) {
            int verDirr = verCuts.get(i)-verCuts.get(i-1);
            if (verDirr > maxHorDiff)
                maxHorDiff = verDirr;
        }
        return (int) ((maxHorDiff*maxVerDiff)%M);
    }
}

