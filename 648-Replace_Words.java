/* Build Trie : 字首樹
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 * TrieTree:
 *        [ ]
 *    /    |    \
 *   b     c     r
 *  /     /     /
 * a     a     a
 *  \     \     \
 *   t     t     t
*/
class Solution {
    class TrieNode {
        TrieNode[] childNode = new TrieNode[26]; //put 26 lower letter
        boolean isWord = false; //if from root to this char build a word
    }
    
    public TrieNode buildTrieNode(List<String> dictionary) {
        TrieNode root = new TrieNode();
        TrieNode current;
        for (String word : dictionary) {
            current = root;
            for (int i = 0; i < word.length(); i++) {
                char l = word.charAt(i);
                if (current.childNode[l - 'a'] == null) {
                    current.childNode[l - 'a'] = new TrieNode();
                }
                current = current.childNode[l - 'a'];
                if (current.isWord) {
                    // exist a shorter word, we can break now
                    break;
                }
            }
            current.isWord = true;
        }
        return root;
    }

    //Complexity: O(word.length())
    public String findReplacedWord(TrieNode root, String word) {
        TrieNode current = root;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char l = word.charAt(i);
            if (current.childNode[l - 'a'] == null) {
                // Not match
                result.setLength(0);
                break;
            };
            result.append(l);
            current = current.childNode[l - 'a'];
            
            if (current.isWord) break;
        }

        if (result.length() == 0) {
            return word;
        } else {
            return result.toString();
        }
    }

    //Compexity: O(n).  n = sentence.length()
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrieNode(dictionary);
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            result.append(findReplacedWord(root, words[i]));
            result.append(" ");
        }
        return result.toString().trim(); // remove last space
    }
}
