package remove_duplicates_from_sorted_array_26;

public class My {
    public static int result(int nums[]){

        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return 1;

        int sum = 1;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != nums[i-1])
                sum+=1;
        }

        return sum;
    }
}

