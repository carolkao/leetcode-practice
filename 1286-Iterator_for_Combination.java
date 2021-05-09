/**
 * 1. Pre generate all combination through DFS (backtracking)
 * 2. Try to record the current index of the combination and find the next without pre generate
 */
class CombinationIterator {
    Queue<String> allCombination = new LinkedList<>();
    int currentIdx = 0;
    
    public CombinationIterator(String characters, int combinationLength) {
        generateAllCombination(0, new StringBuilder(), characters, 0, combinationLength);
    }
    
    private void generateAllCombination(int count, StringBuilder current, String characters, int idx, int len) {
        if (count == len) {
            allCombination.add(current.toString());
            return;
        }
        for (int i = idx; i < characters.length(); i++) {
            generateAllCombination(count + 1, current.append(characters.charAt(i)), characters, i + 1, len);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    public String next() {
        return allCombination.poll();
    }
    
    public boolean hasNext() {
        return !allCombination.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
