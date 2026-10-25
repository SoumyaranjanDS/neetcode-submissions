class Solution {
    static void solve(
        String digits, String[] mapping, List<String> result, StringBuilder output, int index) {
        // base case -> when index goes out of the digits add output and return
        if (index >= digits.length()) {
            result.add(output.toString());
            return;
        }

        // i need the char of the input digit and convert into a int
        int value = digits.charAt(index) - '0';
        // we need the mapped string to that number
        String mappedString = mapping[value];
        // we call recurssion for each letter of that string via a loop
        for (int i = 0; i < mappedString.length(); i++) {
            // we need to append the characters to the output
            output.append(mappedString.charAt(i)); // in output we have the character
            // for the first char of the input digit
            // call recursion for next input digit
            solve(digits, mapping, result, output, index + 1);
            // now for the next combination we need to back track and need empty output
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        // create a mapping array
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // create a list of result to store the strings
        List<String> result = new ArrayList<>();

        // for empty digit
        if(digits.length() == 0) {
            return result;
        }

        // create a string builder to create output strings for each input digits
        StringBuilder output = new StringBuilder();
        // create a index to travel on the digit
        int index = 0;
        solve(digits, mapping, result, output, index);
        return result;
    }
}
