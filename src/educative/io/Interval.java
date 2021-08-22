package educative.io;

public class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start == other.start)
            return this.end - other.end;
        return this.start - other.start;
    }
}
