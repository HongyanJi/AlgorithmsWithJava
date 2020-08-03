    // two pointers
    // for any i, the maxium area will be the farthest j that has a[j] > a[i];
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea; 
    }
