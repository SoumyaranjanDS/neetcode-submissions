class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int rem;
        int x1 = x;

        if(x < 0) {
            return false;
        }

        while(x != 0) {
            rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }
        if(rev == x1) {
            return true;
        }
        else {
            return false;
        }
    }
}