package trapping_raing_water_42;

public class My {
    public int result(int[] height){
        int n = height.length;
        int left = 0;
        int right = 0;
        int water = 0;

        while (left < n-1){
            if (height[left] == 0) {
                left++;
                continue;
            }
            int currWater = 0;
            boolean breaked = false;
            for (right = left+1; right < n; right++){
                if (height[right] >= height[left]){
                    breaked = true;
                    break;
                }
                currWater += height[left]-height[right];
            }
            if (breaked){
                water += currWater;
                left = right;
            }else
                left++;
        }
        return water;
    }
}

