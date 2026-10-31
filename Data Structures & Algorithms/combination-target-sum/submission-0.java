class Solution {
    static void solve(
        int[] nums, int target, int index, List<List<Integer>> ans, List<Integer> result) {
        // base cas
        if (target == 0) {
            ans.add(new ArrayList<>(result));
            return;
        }
        if (index >= nums.length) {
            return;
        }
        if (target < 0) {
            return;
        }
        result.add(nums[index]);
        // include  nums[index]
        solve(nums, target - nums[index], index, ans, result);
        // back track
        result.remove(result.size() - 1);
        // exclude target + 1
        solve(nums, target, index + 1, ans, result);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int index = 0;

        solve(nums, target, index, ans, result);
        return ans;
    }
}
