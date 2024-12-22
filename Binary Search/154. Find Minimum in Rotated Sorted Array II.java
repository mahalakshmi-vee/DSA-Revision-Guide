class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (nums[low] == nums[middle] && nums[middle] == nums[high]) {
                low++;
                high--;
            }
            else if (nums[middle] <= nums[high]) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }
        return nums[high];
    }
}
// Worst case time complexity: O(N) (due to many duplicates)
// Average case time complexity: O(Log N) (binary search-like behavior when few duplicates)
// Space complexity: O(1)