class Solution {
    static int findPivotIndex(int[] nums, int n) {
        int start = 0;
        int end = n - 1;
        int ans = -1;

        if (nums[start] < nums[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[n - 1]) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        // find pivot index
        int pivotIndex = findPivotIndex(nums, n);

        // if pivot index is -1 then the array was already sorted
        if (pivotIndex == -1) {
            return binarySearch(nums, 0, n - 1, target);
        }
        // according to pivot index search on left or right
        if (target >= nums[0] && nums[pivotIndex] >= target) {
            return binarySearch(nums, 0, pivotIndex, target);
        }
        return binarySearch(nums, pivotIndex + 1, n - 1, target);
    }
}
