/* 
 * In a rotated sorted array nums[3,4,5,1,2]
 * if (nums[k] < nums[k - 1]) nums[k] is the minimal number
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 */

class Solution {
    public int findMin(int[] nums) {
        
        // binary search
        int left = 0, right = nums.length - 1;
        
        // All sorted
        if (nums[0] < nums[right]) {
            return nums[0];
        }
                    
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            // compare between mid - 1, mid, mid + 1 to see if there is minimal number 
            if (mid > left && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            
            // if left-half side sorted, the minimal should be in right-half side
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return nums[left];
    }
}

