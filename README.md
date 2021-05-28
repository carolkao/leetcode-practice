# leetcode-practice

## Java Note
### [StringBuilder]
Backtracking 時可能會用到, 比String + 效率好
```java
StringBuilder sb = new StringBuilder();
sb.append("123");
sb.deleteCharAt(sb.length() - 1);
```
StringBuilder 長度相關
```java
StringBuilder sb = new StringBuilder();
int len = sb.length();
// 清空sb
sb.setLength(0);
```
### [List <-> Array]
```java
//List to Array
String[] strarray = list.toArray(new String[list.size()]);

// Array to List
List<String> list = Arrays.asList(strarray);
List<String> list = Arrays.asList(strarray[i], strarray[j], strarray[k]);
```

### [填滿Array]
```java
Arrays.fill(array, value)
```

## TO Review List
### Array
### String
### Binary Search
```java
// input: int[] nums

int left = 0, right = nums.length - 1, mid;

while (left < right) {
    // not use (left + right) / 2 to avoid overflow
    mid = left + (right - left) / 2;

    // some specific condition
    // xxx

    // choose left-half or right-half
    if (meet right-half condition) {
        left = mid + 1; //or left = mid  (by different situation)
    } else {
        right = mid - 1; //or right = mid (by different situation)
    }
}
```
### BFS
### DFS / Backtracking
```java 
// Backtracking Sample

void dfs(List<List<Integer>> result, List<Integer> current, int startIdx, int[] nums) {
    if (meet criteria) {
        result.add(new ArrayList<>(current);
        return;
    }

    for (int i = startIdx; i < nums.length; i++) {
        current.add(nums[i]);
        dfs(result, current, i+1, nums);
        current.remove(current.size() - 1);
    }
}
```
### DP
### Two Pointer
### Sliding Window
```java
int left=0, right=0;
while (right < len) {
    // do somthing

    // if match criteria, start to move left to reduce the window size
    while (match criteria && left <= right) {
        // do somthing
        left++;
    }

    // criteria not match, so keep moving right
    right++;
}
```
### Tree
#### Trie : 字典樹
```java
TrieNode {
    TrieNode[] childNode = new TrieNode[26]; // 26 lower letters
    boolean isWord = false; // from root to current letter compose a word
}

TrieNode root = new TrieNode(); //empty root
for (String dicWord : dictionary) {
    // build TrieTree from root
}
```
### Stack
### Queue
### Heap

## History
### 2021-05-09
Happy Monther's Day, begin this project
