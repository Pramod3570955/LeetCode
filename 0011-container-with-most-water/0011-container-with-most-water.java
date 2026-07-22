class Solution {
    public int maxArea(int[] height) {
      int i = 0;
      int j = height.length-1;
      int area = Integer.MIN_VALUE;
      int maxarea = Integer.MIN_VALUE;

      while(i < j) 
      {
        int w = j - i;
        int h = Math.min(height[i],height[j]);
        area = w * h;
        maxarea = Math.max(area,maxarea);
        if (height[i] < height[j])
        {
            i++;
        }
        else
        {
            j--;
        }
      }
    return maxarea;  
    }
}