class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int waterContains = 0;

        while (i < j) {
            waterContains = Math.max(waterContains, (j - i) * Math.min(heights[i], heights[j]));

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return waterContains;
    }
}
