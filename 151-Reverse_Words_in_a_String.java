// I can think of top of my head is to use 'Stack'
// Save each words into a stack and then pop and concatenate to the result string
//
// There is another solution to use two pointer:
//    1. reverse whole string
//    2. reverse each words
//    3. remove redundant spaces
class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        
        StringBuilder currentString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (currentString.length() > 0) {
                    stack.push(currentString.toString());
                    currentString.setLength(0);
                }
            } else {
                currentString.append(s.charAt(i));
            }
        }
        // Remember to push the latest string
        if (currentString.length() > 0) {
            stack.push(currentString.toString());
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
