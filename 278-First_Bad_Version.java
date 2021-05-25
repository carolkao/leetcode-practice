/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/*
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // binary search
        
        int left = 1, right = n;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // mid is bad, the min bad should be in left-half side
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
