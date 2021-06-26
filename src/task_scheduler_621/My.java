package task_scheduler_621;

public class My {
    public int result(char[] tasks, int n){
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;

        for (char c : tasks){
            counter[c-'A']++;
            if (counter[c-'A'] > max){
                max = counter[c-'A'];
                maxCount = 1;
            } else if (counter[c-'A'] == max)
                maxCount++;
        }
        int positions = Math.max(0, ((max-1)*(n - (maxCount-1))) );
        positions = positions - (tasks.length-(max*maxCount));
        return tasks.length+Math.max(0,positions);
    }
}

