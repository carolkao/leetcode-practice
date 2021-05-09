/**
 * Example : [1,2,2,3]
 * 1. DFS (Backtracking)
 *    [], [1], [1,2], [1,2,2], [1,2,2,3], [1,2,3], [1,3] [2], [2,2], [2,2,3], [2,3], [3]
 * 2. BFS
 *    [], [1], [2], [1,2], [2,2], [1,2,2], [3], [1,3], [2,3], [1,2,3], [2,2,3], [1,2,2,3]
 *                         ^ add into [2] & [1,2]
 **/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sorted to avoid duplicate
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, nums);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> current, int startIdx, int[] nums) {
        result.add(new ArrayList<>(current));
        
        if (startIdx >= nums.length) return;
        
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) continue;
            
            current.add(nums[i]);
            dfs(result, current, i+1, nums);
            current.remove(current.size() - 1);
        }
        
    }
    
    
    // BFS
    // [1,2,2,3]
    // init: []
    // 0: [1]
    // 1: [2], [1,2]
    // 2: -> same with previous, start from 'lastLevelStart = 2' -> start index in result set
    //    [2,2], [1,2,2]
    // 3: [3],[1,3],[2,3],[1,2,3],[2,2,3],[1,2,2,3]
    public List<List<Integer>> subsetsWithDup_BFS(int[] nums) {
        Arrays.sort(nums);
       
        List<List<Integer>> result = new ArrayList<>();
        // add an empty set first
        result.add(new ArrayList<>());
        
        int len = nums.length;
        int i = 0;
        int size, lastLevelStart = 0;
        while (i < len) {
            int startIdx = 0;
            if (i > 0 && nums[i] == nums[i-1]) {
                //only need to add the number into last level sets
                startIdx = lastLevelStart;
            }
            size = lastLevelStart = result.size();
            
            for (int j = startIdx; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
            
            i++;
        }
        
        return result;
    }
}
