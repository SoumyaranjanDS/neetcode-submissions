class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int ans = 0;

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int currentNum = x;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
