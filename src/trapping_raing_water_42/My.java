package trapping_raing_water_42;

public class My {
    public int result(int[] height){
        int n = height.length;
        if (n == 0)
            return 0;
        int leftMax = height[0];
        int water = 0;
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for (int i = n-2; i >= 0; i--)
            rightMax[i] = Math.max(height[i],rightMax[i+1]);

        for (int i = 1; i < n; i++){
            water += Math.max(0,Math.min(leftMax,rightMax[i])-height[i]);
            if (height[i] > leftMax)
                leftMax = height[i];
        }
        return water;
    }
}

