package Number_of_one_Bits_191;

public class My {
    public static int result(int n){

        int mask = 1;
        int count = 0;

        for(int i = 0; i < Integer.BYTES * 8; i++){
            if( (mask & n) == mask ) count++;
            mask = mask << 1;
        }

        return count;
    }
}

