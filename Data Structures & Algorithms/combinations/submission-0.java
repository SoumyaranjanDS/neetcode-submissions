class Solution {
    static void solve(int n, int k, int index, List<List<Integer>> ans, ArrayList<Integer> output) {
        // Base case
        if (output.size() == k) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (index > n) {
            return;
        }

        // Include
        output.add(index);
        solve(n, k, index + 1, ans, output);

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude
        solve(n, k, index + 1, ans, output);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(n, k, 1, ans, new ArrayList<>());

        return ans;
    }
}