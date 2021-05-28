// Sliding Windows Solution
class Solution {
    
    public String minWindow(String s, String t) {
        int tLen = t.length();
		// Build HashMap.
        // (Since the char only contains english letter, we can also use Array instead to improve performance)
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < tLen; i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		// Use two pointer to find the minimal window
		int sLen = s.length();
		int left = 0, right = 0;
		int count = 0;
		int minSize = sLen;
        // It's possible that there is no answer, the startIdx should not be init as 0
		int startIdx = -1;
		while (right < sLen) {
			
			// extend right pointer to match all criteria
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				if (map.get(c) > 0) {
					count++;
				}
				map.put(c, map.get(c) - 1);
			}

			// criteria match
			// move left pointer to reduce windows size
			while (count == tLen && left <= right) {
				int currentWindowsSize = right - left + 1;
				if (startIdx == -1 || currentWindowsSize < minSize) {
					startIdx = left;
					minSize = currentWindowsSize;
				}
				char c2 = s.charAt(left);
				if (map.containsKey(c2)) {
					map.put(c2, map.get(c2) + 1);
					if (map.get(c2) >= 1) {
						count--;
					}
				}
				left++;
			}
			
			right++;
		}
        
		if (startIdx == -1) {
            return "";
        } else {
		    return s.substring(startIdx, startIdx + minSize);
        }
    }
}
