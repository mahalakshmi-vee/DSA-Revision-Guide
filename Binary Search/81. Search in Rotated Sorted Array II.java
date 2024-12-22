class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target) return true;
            else if (nums[low] == nums[middle] && nums[middle] == nums[high]) {
                low++;
                high--;
            }
            else if (nums[low] <= nums[middle]) { // Left part of middle is obviously sorted.
                if (target >= nums[low] && target <= nums[middle]) {
                    high = middle - 1;
                }
                else {
                    low = middle + 1;
                }
            }
            else { // Right part of middle is obviously sorted.
                if (target >= nums[middle] && target <= nums[high]) {
                    low = middle + 1;
                }
                else {
                    high = middle - 1;
                }
            }   
        }
        return false;
    }
}
// Worst case time complexity: O(N) (due to many duplicates)
// Average case time complexity: O(Log N) (binary search-like behavior when few duplicates)
// Space complexity: O(1)
