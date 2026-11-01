class Solution {
    static boolean isSafeToMove(int rowIndex, int colIndex, char[][] board, int n) {
        // check 3 directions to the left

        // check top left
        int row = rowIndex;
        int col = colIndex;

        while (col >= 0 && row >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row--;
        }
        // check horizontal
        row = rowIndex;
        col = colIndex;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        // check lower left
        row = rowIndex;
        col = colIndex;
        while (col >= 0 && row < n) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    static void solve(char[][] board, int colIndex, List<List<String>> ans, int n) {
        // base case
        if (colIndex >= n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        // now for each row in a column
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if(isSafeToMove(rowIndex, colIndex, board, n)) {
                // add q to the index
                board[rowIndex][colIndex] = 'Q';
                // call recursion for next column
                solve(board, colIndex + 1, ans, n);
                // backtrack
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();
        solve(board, colIndex, ans, n);
        return ans;
    }
}
