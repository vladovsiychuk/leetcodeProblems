package container_with_most_water_11;

public class My {
    public int result(int[] height){
        int left = 0;
        int right = height.length-1;
        int maxCapacity = 0;

        while (left < right){
            maxCapacity = Math.max(
                    maxCapacity,
                    Math.max(height[left],height[right])*(right-left)
                    );

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxCapacity;
    }
}

