class Solution {
    static void solve(int[] candidates, int target, int index, List<List<Integer>> ans,
        ArrayList<Integer> output) {
        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index + 1, ans, output);
        output.remove(output.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        solve(candidates, target, index + 1, ans, output);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, index, ans, new ArrayList<>());
        return ans;
    }
}
