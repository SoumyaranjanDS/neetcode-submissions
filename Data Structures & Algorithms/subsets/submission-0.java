class Solution {
    static void solve(int[] nums, List<List<Integer>> ans, List<Integer> output, int index) {
        // base case
        if (index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // current index value
        int value = nums[index];

        // include
        output.add(value);
        solve(nums, ans, output, index + 1);
        // backtrack
        output.remove(output.size() - 1);
        // exclude
        solve(nums, ans, output, index + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(nums, ans, output, index);
        return ans;
    }
}
